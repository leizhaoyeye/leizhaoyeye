package com.example.zhaolei.util;

import lombok.extern.slf4j.Slf4j;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Slf4j
public class ImageToBase64Util {

    public static byte[] urltoByte(String imgUrl){
        log.info("图片路径为：" + imgUrl);
        byte[] result = null;
        InputStream inStream = null;
        String photo = "";
        URL url = null;
        HttpURLConnection conn = null;
        try {
            //创建URL
            url = new URL(imgUrl);
            //创建连接
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);
            conn.setRequestProperty("Accept-Encoding", "identity");
            conn.connect();

            inStream = conn.getInputStream();
            int count = conn.getContentLength();//获取远程资源长度
            result = new byte[count];
            int readCount = 0;
            while (readCount < count) {//循环读取数据
                readCount += inStream.read(result, readCount, count - readCount);
            }
        } catch (Exception e) {
            log.error("获取远程图片失败", e);
        } finally {
            try {
                if (inStream != null) {
                    inStream.close();
                }
                if (conn != null) {
                    conn.disconnect();
                }
            } catch (IOException e) {
                log.error("文件处理错误!", e);
            }
            log.info("o==||=====>读取图片返回");
        }
        return result;
    }

    public static String urlToString(String imgUrl) {
        byte[] result = urltoByte(imgUrl);
        if(result.length == 0){
            return null;
        }
        return toBase64(result);
    }

    private static String toBase64(byte[] imgData) {
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(imgData);
    }

    public static byte[] base64toByte(String base64Str) throws IOException {
        BASE64Decoder decoder = new BASE64Decoder();
        return decoder.decodeBuffer(base64Str);
    }

}
