package com.example.zhaolei.util;


import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.SocketException;
import java.nio.charset.Charset;


import org.apache.commons.net.ftp.*;
import org.apache.http.entity.ContentType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
public class FtpUtil {

    /**
     * 获取FTPClient对象
     *
     * @param ftpHost     FTP主机服务器
     * @param ftpPassword FTP 登录密码
     * @param ftpUserName FTP登录用户名
     * @param ftpPort     FTP端口 默认为21
     * @return
     */
    public static FTPClient getFTPClient(String ftpHost, String ftpUserName, String ftpPassword, int ftpPort) {


        FTPClient ftpClient = null;

        try {
            //创建一个ftp客户端
            ftpClient = new FTPClient();
            // 连接FTP服务器
            ftpClient.connect(ftpHost, ftpPort);
            // 登陆FTP服务器
            ftpClient.login(ftpUserName, ftpPassword);

            if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
                log.info("未连接到FTP，用户名或密码错误。");
                ftpClient.disconnect();
            } else {
                log.info("FTP连接成功。");
            }
        } catch (SocketException e) {
            e.printStackTrace();
            log.info("FTP的IP地址可能错误，请正确配置。");
        } catch (IOException e) {
            e.printStackTrace();
            log.info("FTP的端口错误,请正确配置。");
        }
        return ftpClient;
    }


    /**
     * 下载文件
     *
     * @param ftpHost     ftp服务器地址
     * @param ftpUserName anonymous匿名用户登录，不需要密码。administrator指定用户登录
     * @param ftpPassword 指定用户密码
     * @param ftpPort     ftp服务员器端口号
     * @param ftpPath     ftp文件存放物理路径
     * @param fileName    文件路径
     */
    public static void downloadFile(String ftpHost, String ftpUserName, String ftpPassword, int ftpPort, String ftpPath, String localPath, String fileName) {

        FTPClient ftpClient = null;

        try {
            ftpClient = getFTPClient(ftpHost, ftpUserName, ftpPassword, ftpPort);
            ftpClient.setControlEncoding("UTF-8"); // 中文支持
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();
            ftpClient.changeWorkingDirectory(ftpPath);

            File localFile = new File(localPath + File.separatorChar + fileName);
            OutputStream os = new FileOutputStream(localFile);
            ftpClient.retrieveFile(fileName, os);
            os.close();
            ftpClient.logout();

        } catch (FileNotFoundException e) {
            log.error("没有找到" + ftpPath + "文件");
            e.printStackTrace();
        } catch (SocketException e) {
            log.error("连接FTP失败.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            log.error("文件读取错误。");
            e.printStackTrace();
        }
    }

    /**
     * 上传文件
     *
     * @param ftpHost     ftp服务器地址
     * @param ftpUserName anonymous匿名用户登录，不需要密码。administrator指定用户登录
     * @param ftpPassword 指定用户密码
     * @param ftpPort     ftp服务员器端口号
     * @param ftpPath     ftp文件存放物理路径
     * @param fileName    文件路径
     * @param input       文件输入流，即从本地服务器读取文件的IO输入流
     */
    public static void uploadFile(String ftpHost, String ftpUserName, String ftpPassword, int ftpPort, String ftpPath, String fileName, InputStream input) {
        FTPClient ftp = null;
        try {
            ftp = getFTPClient(ftpHost, ftpUserName, ftpPassword, ftpPort);

            ftp.makeDirectory(ftpPath);
            ftp.changeWorkingDirectory(ftpPath);

            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            fileName = new String(fileName.getBytes("GBK"), "iso-8859-1");
            ftp.storeFile(fileName, input);
            input.close();
            ftp.logout();
            System.out.println("upload succes!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private  static  FTPClient  ftp;
    private  static  InputStream is;
    private  static  FileOutputStream  fos;
    /**
     * 验证登录
     * @param ip
     * @param port
     * @param name
     * @param pwd
     * @return
     */
    public static boolean login(String ip, int port, String name, String pwd) {
        try {
            ftp = new FTPClient();
            ftp.connect(ip, port);
            System.out.println(ftp.login(name, pwd));
            if(!ftp.login(name, pwd)){
                return false;
            }
            ftp.setCharset(Charset.forName("UTF-8"));
            ftp.setControlEncoding("UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 下载文件的第二种方法，优化了传输速度
     * @param ip
     * @param port
     * @param name
     * @param pwd
     * @param remotepath 远程地址文件路径
     * @param localpath 本地文件路径
     * @return
     */
    public static boolean getFileTwo(String ip, int port, String name, String pwd, String remotepath, String localpath) {
        try {
            if(!login(ip, port, name, pwd)){
                return false;
            }
            is = ftp.retrieveFileStream(remotepath);
            fos = new FileOutputStream(new File(localpath));
            byte[] b = new byte[1024];
            int len = 0;
            while ((len = is.read(b)) != -1) {
                fos.write(b,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }


    private static String encoding = System.getProperty("file.encoding");
    public static boolean downFile(String url, int port, String username,
                                   String password, String remotePath, String fileName,
                                   String localPath) {
        boolean result = false;
        try {
            int reply;
            ftp.setControlEncoding(encoding);
            /*
             * 为了上传和下载中文文件，有些地方建议使用以下两句代替
             * new String(remotePath.getBytes(encoding),"iso-8859-1")转码。
             * 经过测试，通不过。
             */
            // FTPClientConfig conf = new FTPClientConfig(FTPClientConfig.SYST_NT);
            // conf.setServerLanguageCode("zh");
            ftp.connect(url, port);
            // 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
            ftp.login(username, password);// 登录
            // 设置文件传输类型为二进制
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            // 获取ftp登录应答代码
            reply = ftp.getReplyCode();
            // 验证是否登陆成功
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                System.err.println("FTP server refused connection.");
                return result;
            }
            // 转移到FTP服务器目录至指定的目录下
            ftp.changeWorkingDirectory(new String(remotePath.getBytes(encoding),"iso-8859-1"));
            // 获取文件列表
            FTPFile[] fs = ftp.listFiles();
            for (FTPFile ff : fs) {
                if (ff.getName().equals(fileName)) {
                    File localFile = new File(localPath + "/" + ff.getName());
                    OutputStream is = new FileOutputStream(localFile);
                    ftp.retrieveFile(ff.getName(), is);
                    is.close();
                }
            }
            ftp.logout();
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return result;
    }


    /**
     * Description: 向FTP服务器上传文件
     * @param host FTP服务器hostname
     * @param port FTP服务器端口
     * @param username FTP登录账号
     * @param password FTP登录密码
     * @param basePath FTP服务器基础目录
     * @param filePath FTP服务器文件存放路径。例如分日期存放：/2015/01/01。文件的路径为basePath+filePath
     * @param filename 上传到FTP服务器上的文件名
     * @param input 输入流
     * @return 成功返回true，否则返回false
     */
    public static boolean uploadFile(String host, int port, String username, String password, String basePath,
                                     String filePath, String filename, InputStream input) {
        boolean result = false;
        FTPClient ftp = new FTPClient();
        try {
            int reply;
            ftp.connect(host, port);// 连接FTP服务器
//            ftp.connect(host);
//             如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器
            ftp.login(username, password);// 登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return result;
            }
            //切换到上传目录
            if (!ftp.changeWorkingDirectory(basePath+filePath)) {
                //如果目录不存在创建目录
                String[] dirs = filePath.split("/");
                String tempPath = basePath;
                for (String dir : dirs) {
                    if (null == dir || "".equals(dir)) continue;
                    tempPath += "/" + dir;
                    if (!ftp.changeWorkingDirectory(tempPath)) {
                        if (!ftp.makeDirectory(tempPath)) {
                            return result;
                        } else {
                            ftp.changeWorkingDirectory(tempPath);
                        }
                    }
                }
            }
//
//            //为了加大上传文件速度，将InputStream转成BufferInputStream
//            BufferedInputStream  in=new BufferedInputStream(input);
            //加大缓存区
//            ftp.setBufferSize(1024*1024);
            //设置上传文件的类型为二进制类型
            ftp.setFileType(FTP.BINARY_FILE_TYPE);

            System.out.println("开通端口来传输数据.....................");
            ftp.enterLocalPassiveMode();
            //上传文件
            if (!ftp.storeFile(filename, input)) {
                return result;
            }
            input.close();
            ftp.logout();
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return result;
    }

    /**
     * Description: 从FTP服务器下载文件
     * @param host FTP服务器hostname
     * @param port FTP服务器端口
     * @param username FTP登录账号
     * @param password FTP登录密码
     * @param remotePath FTP服务器上的相对路径
     * @param fileName 要下载的文件名
     * @param localPath 下载后保存到本地的路径
     * @return
     */
    public static BufferedOutputStream downloadFile(String host, int port, String username, String password, String remotePath,
                                       String fileName, String localPath) {
        boolean result = false;
        BufferedOutputStream bufferedOutputStream =null;
        FTPClient ftp = new FTPClient();
        try {
            int reply;
            ftp.connect(host, port);
            // 如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器
            ftp.login(username, password);// 登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return null;
            }
            ftp.changeWorkingDirectory(remotePath);// 转移到FTP服务器目录
            FTPFile[] fs = ftp.listFiles();
            for (FTPFile ff : fs) {
                if (ff.getName().equals(fileName)) {
                    File localFile = new File(localPath + "/" + ff.getName());
                    OutputStream os = new FileOutputStream(localFile);
                    ftp.retrieveFile(ff.getName(), os);
                    bufferedOutputStream = new BufferedOutputStream(os);
                    os.close();
                }
            }

            ftp.logout();
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return bufferedOutputStream;
    }

    /**
     * Description: 从FTP服务器下载文件
     * @param host FTP服务器hostname
     * @param port FTP服务器端口
     * @param username FTP登录账号
     * @param password FTP登录密码
     * @param remotePath FTP服务器上的相对路径
     * @param fileName 要下载的文件名
     * @param localPath 下载后保存到本地的路径
     * @return
     */
    public static File downloadFile2(String host, int port, String username, String password, String remotePath,
                                                    String fileName, String localPath) {
        boolean result = false;
        BufferedOutputStream bufferedOutputStream =null;
        FTPClient ftp = new FTPClient();
        File localFile =null;
        try {
            int reply;
            ftp.connect(host, port);
            // 如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器
            ftp.login(username, password);// 登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return null;
            }
            FTPClientConfig conf = new FTPClientConfig(FTPClientConfig.SYST_UNIX);

            ftp.changeWorkingDirectory(remotePath);// 转移到FTP服务器目录
            //进入被动模式  主动模式的FTP是指服务器主动连接客户端的数据端口   被动模式的FTP是指服务器被动地等待客户端连接自己的数据端口
            //ftp.enterLocalPassiveMode();
            FTPFile[] fs = ftp.listFiles();
            for (FTPFile ff : fs) {
                if (ff.getName().equals(fileName)) {
                    localFile= new File(localPath + "/" + ff.getName());
                    OutputStream os = new FileOutputStream(localFile);
                    bufferedOutputStream = new BufferedOutputStream(os);
                    //从服务器 检索选定的文件名 ，并写入给的输出流中
                    boolean b = ftp.retrieveFile(ff.getName(), bufferedOutputStream);
                    if (b){
                        log.info("成功");
                    }else {
                        log.info("从服务器检索选定的文件名 ，并写入给的输出流中异常");
                    }

                }
            }
            ftp.logout();
            bufferedOutputStream.flush();
            return localFile;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        File file = downloadFile2("10.50.23.21", 21, "jzzd", "jzzd123456", "/00/11/", "ODS_SOC_CHK_BAYO_PASVEH_INFO.xlsx", "G:/");
        String name = file.getName();
        System.out.println(name);

        FileInputStream fileInputStream = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile(file.getName(), file.getName(),
                ContentType.APPLICATION_OCTET_STREAM.toString(), fileInputStream);
        System.out.println(multipartFile.getName());
        System.out.println(multipartFile.getSize());
    }



}