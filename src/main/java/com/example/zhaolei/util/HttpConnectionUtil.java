package com.example.zhaolei.util;

import org.apache.log4j.Logger;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;


/**
 * Java原生的API可用于发送HTTP请求，即java.net.URL、java.net.URLConnection，这些API很好用、很常用，
 * 但不够简便；
 * <p>
 * 1.通过统一资源定位器（java.net.URL）获取连接器（java.net.URLConnection） 2.设置请求的参数 3.发送请求
 * 4.以输入流的形式获取返回内容 5.关闭输入流
 */
public class HttpConnectionUtil {

    private static Logger logger = Logger.getLogger(HttpConnectionUtil.class);

    /**
     * @param urlPath      下载路径
     * @param fileSavePath 下载存放目录,包含文件名
     * @return 返回下载文件
     * @throws Exception
     */
    public static void downloadFile(String urlPath, String fileSavePath, String fileName) throws Exception {
        logger.info("进入下载文件工具类");
        File file = null;
        BufferedInputStream bin = null;
        OutputStream out = null;
        try {
            // 统一资源
            URL url = new URL(urlPath);
            // 连接类的父类，抽象类
            URLConnection urlConnection = url.openConnection();
            // http的连接类
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
            // 设定请求的方法，默认是GET
            httpURLConnection.setRequestMethod("GET");
            // 设置字符编码
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            // 打开到此 URL 引用的资源的通信链接（如果尚未建立这样的连接）。
            httpURLConnection.connect();
//            // 文件大小
//            int fileLength = httpURLConnection.getContentLength();
//
//            // 文件名
//            String filePathUrl = httpURLConnection.getURL().getFile();
//            String fileFullName = filePathUrl.substring(filePathUrl.lastIndexOf(File.separatorChar) + 1);
//            fileFullName = fileFullName.substring(fileFullName.lastIndexOf("/") + 1);
//            logger.info("开始下载文件：" + fileFullName);
//            logger.info("file length---->" + fileLength);
            url.openConnection();

            bin = new BufferedInputStream(httpURLConnection.getInputStream());

            String path = fileSavePath + File.separator + fileName;
            file = new File(path);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            out = new FileOutputStream(file);
            int size = 0;
            byte[] buf = new byte[1024];
            while ((size = bin.read(buf)) != -1) {
                out.write(buf, 0, size);
            }
        } catch (Exception e) {
            logger.error("文件下载异常, fail msg =", e);
        } finally {
            if (bin != null) {
                bin.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
