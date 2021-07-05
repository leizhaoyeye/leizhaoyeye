package com.example.zhaolei.util;



import com.example.zhaolei.constant.Constant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * @author by Ruise on 2018/6/5.
 */
@Slf4j
public class FileUtil {

    private static final int CONNECT_TIMEOUT = 6000;
    private static final int INT_SIZE = 2048;

    public static void downloadHttpsFile(String fileUrl, File localFile) throws Exception {
        SSLContext sslcontext = SSLContext.getInstance("SSL", "SunJSSE");
        sslcontext.init(null, new TrustManager[]{new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] x509Certificates, String s)
                    throws CertificateException {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] x509Certificates, String s)
                    throws CertificateException {
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        }}, new java.security.SecureRandom());

        HostnameVerifier ignoreHostnameVerifier = new HostnameVerifier() {
            @Override
            public boolean verify(String s, SSLSession sslsession) {
                return true;
            }
        };
        HttpsURLConnection.setDefaultHostnameVerifier(ignoreHostnameVerifier);
        HttpsURLConnection.setDefaultSSLSocketFactory(sslcontext.getSocketFactory());

        URL url = new URL(fileUrl);
        HttpsURLConnection urlCon = (HttpsURLConnection) url.openConnection();
        urlCon.setConnectTimeout(CONNECT_TIMEOUT);
        urlCon.setReadTimeout(CONNECT_TIMEOUT);
        int code = urlCon.getResponseCode();
        if (code != HttpURLConnection.HTTP_OK) {
            throw new Exception("文件读取失败");
        }
        // 读文件流
        saveFile(localFile, urlCon);
    }

    public static void downloadHttpFile(String fileUrl, File localFile) throws Exception {
        URL url = new URL(fileUrl);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setConnectTimeout(CONNECT_TIMEOUT);
        urlConnection.setReadTimeout(CONNECT_TIMEOUT);
        // 读文件流
        if (urlConnection.getResponseCode() != HttpURLConnection.HTTP_OK) {
            throw new Exception("文件读取失败");
        }
        saveFile(localFile, urlConnection);
    }

    private static void saveFile(File localFile, HttpURLConnection urlConnection) throws Exception {
        // 读文件流
        try (DataInputStream in = new DataInputStream(urlConnection.getInputStream());
             DataOutputStream out = new DataOutputStream(new FileOutputStream(localFile))) {
            byte[] buffer = new byte[INT_SIZE];
            int count = 0;
            while ((count = in.read(buffer)) > 0) {
                out.write(buffer, 0, count);
            }
        } catch (IOException e) {
            log.error("文件保存失败", e);
            throw new Exception("文件保存失败");
        }
    }

    public static void deleteFile(String fileName) {
        deleteFile(new File(fileName));
    }

    public static void deleteFile(File tmpFile) {
        if (!tmpFile.exists()) {
            return;
        }
        if (tmpFile.isDirectory()) {
            try {
                FileUtils.deleteDirectory(tmpFile);
                tmpFile.delete();
            } catch (IOException e) {
                log.warn("IOException", e);
            }
        } else if (!tmpFile.delete()) {
            log.warn("tmpFile path [{}] name [{}] delete fail ", tmpFile.getPath(),
                    tmpFile.getName());
            return;
        }
    }

    public static void downloadFile(String fileUrl, File tmpFile) throws Exception {
        if (fileUrl.startsWith("https")) {
            downloadHttpsFile(fileUrl, tmpFile);
        } else if (fileUrl.startsWith("http")) {
            downloadHttpFile(fileUrl, tmpFile);
        }
    }

    /**
     * 保存本地文件
     * @param inputStream
     * @param url
     */
    public static void saveLocalFile(InputStream inputStream, String url) {
        try (OutputStream os = new FileOutputStream(url)) {
            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            while ((len = inputStream.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createDirs(String dirName) {
        File file = new File(dirName);
        if (file.exists() || file.mkdirs()) {
            return;
        }
        log.error("文件夹[{}]创建失败", dirName);
    }
    /**
     * 功能:文件类型转换
     * @author Itwalder
     */
    public static ByteArrayOutputStream inputStream2ByteArrayOutputStream(File file) {
        InputStream inputStream = null;
        BufferedInputStream bis = null;
        ByteArrayOutputStream bos = null;
        try {
            inputStream = new FileInputStream(file);
            bis = new BufferedInputStream(inputStream);
            bos = new ByteArrayOutputStream();
            int data = -1;
            while ((data = bis.read()) != -1) {
                bos.write(data);
            }
            bos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try { bis.close(); } catch (IOException e) { }
            try { inputStream.close(); } catch (IOException e) {}
            try { bos.close(); } catch (IOException e) {}
        }
        return bos;
    }


    /**
     * 生产环境使用   inputStream转为 File 文件对象
     * @param fileName
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static File asFile(String fileName,InputStream inputStream) throws IOException{
        File tmp = File.createTempFile(fileName, ".xls", new File(Constant.LOCAL_TMP_DIR));
        OutputStream os = new FileOutputStream(tmp);
        int bytesRead = 0;
        byte[] buffer = new byte[8192];
        while ((bytesRead = inputStream.read(buffer, 0, 8192)) != -1) {
            os.write(buffer, 0, bytesRead);
        }
        inputStream.close();
        return tmp;
    }
    public static File asFile(String fileName,String fileType,InputStream inputStream) throws IOException{
        File tmp = File.createTempFile(fileName, "."+fileType, new File(Constant.LOCAL_TMP_DIR));
        OutputStream os = new FileOutputStream(tmp);
        int bytesRead = 0;
        byte[] buffer = new byte[8192];
        while ((bytesRead = inputStream.read(buffer, 0, 8192)) != -1) {
            os.write(buffer, 0, bytesRead);
        }
        inputStream.close();
        return tmp;
    }

    /**
     * ByteArrayOutputStream  转换为   InputStream
     * @param in
     * @return
     */
    public static InputStream streamTran(ByteArrayOutputStream in) {
        return new ByteArrayInputStream(in.toByteArray());
    }
}
