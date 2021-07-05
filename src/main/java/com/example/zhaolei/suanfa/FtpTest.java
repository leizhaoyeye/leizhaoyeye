package com.example.zhaolei.suanfa;


import com.example.zhaolei.util.FtpUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.http.entity.ContentType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Slf4j
public class FtpTest {


     public static void main(String[] args) throws IOException {
          FTPClient ftpClient = FtpUtil.getFTPClient("10.50.23.21", "jzzd", "jzzd123456", 21);
          System.out.println(ftpClient);
          boolean b1 = ftpClient.changeWorkingDirectory("/00");
          System.out.println("改变工作目录是否成功： "+b1);
          try {
               FTPFile[] ftpFiles = ftpClient.listDirectories("/00");
               log.info("文件夹个数: "+ftpFiles.length);
               for (FTPFile ftpFile : ftpFiles) {
                    System.out.println(ftpFile.getName());
               }
          } catch (IOException e) {
               log.info("获取服务器文件列表失败");
               e.printStackTrace();
          }

          FTPFile[] ftpFiles = ftpClient.listFiles();
          log.info("文件个数: "+ftpFiles.length);
          for (FTPFile ftpFile : ftpFiles) {
               System.out.println(ftpFile.getName());
          }

          /*boolean b = ftpClient.makeDirectory("/test/zl");
          System.out.println("创建文件夹是否成功： "+b);*/

          //列出目录
          FTPFile[] dirs = ftpClient.listDirectories("/test");
          for(FTPFile f : dirs ){
               System.out.println(f.getName().getBytes("iso-8859-1"));
          }

          //ftpClient.changeWorkingDirectory(new String(remotePath.getBytes(encoding),"iso-8859-1"));
          //上传测试
          System.out.println("-------------分-------------割-------------线-------------");
          ftpClient.setFileType(FTP.BINARY_FILE_TYPE);//设置上传格式
          InputStream  is = new FileInputStream("C:\\Users\\Administrator\\Desktop\\危废模型\\ODS_SOC_CHK_BAYO_PASVEH_INFO.xlsx");
          //FtpUtil.uploadFile("10.50.23.21", "jzzd", "jzzd123456", 21,"/00/11/","ODS_SOC_CHK_BAYO_PASVEH_INFO.xlsx",is);

          //下载测试
          System.out.println("-------------分-------------割-------------线-------------");
          //FtpUtil.downloadFile("10.50.23.21", "jzzd", "jzzd123456", 21,"/","E:/","涉网制假售假预警模型研判方法与流程交底书.docx");


          //boolean fileTwo = FtpUtil.getFileTwo("10.50.23.21", 21, "jzzd", "jzzd123456", "/00/11/123.docx/", "D:\\Acrobat\\涉网制假售假预警模型研判方法与流程交底书.docx");
          //System.out.println(fileTwo);

          /*boolean flag = FtpUtil.downFile("10.50.23.21", 21, "jzzd",
                  "jzzd123456", "/00/11/", "123.docx", "E:/");
          System.out.println(flag);*/
          //  能用的

          BufferedOutputStream bufferedOutputStream = FtpUtil.downloadFile("10.50.23.21", 21, "jzzd", "jzzd123456", "/00/11/", "ODS_SOC_CHK_BAYO_PASVEH_INFO.xlsx", "G:/JDP/anheng/zhaolei/target/classes/static/");
          System.out.println(bufferedOutputStream);


          System.out.println("-------------分-------------割-------------线-------------");

          File file = FtpUtil.downloadFile2("10.50.23.21", 21, "jzzd", "jzzd123456", "/00/11/", "ODS_SOC_CHK_BAYO_PASVEH_INFO.xlsx", "G:/");
          String name = file.getName();
          System.out.println(name);

          FileInputStream fileInputStream = new FileInputStream(file);
          MultipartFile multipartFile = new MockMultipartFile(file.getName(), file.getName(),
                  ContentType.APPLICATION_OCTET_STREAM.toString(), fileInputStream);
          System.out.println(multipartFile.getName());
          System.out.println(multipartFile.getSize());

     }
}
