package com.example.zhaolei.util;


import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;

import java.io.*;
import java.util.Map;
import java.util.Set;

@Slf4j
public class WordUtils {

    public static byte[] docContentChange(InputStream is, Map<String, String> params) throws IOException {
        HWPFDocument document = new HWPFDocument(is);
        Range range = document.getRange();

        Set<String> keys = params.keySet();
        for (String key : keys) {
            range.replaceText(key, params.get(key));
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        document.write(baos);
        byte[] bytes = baos.toByteArray();


        //document.close();
        baos.close();
        return bytes;
    }


    /**
     * 根据byte数组，生成文件
     * filePath  文件路径
     * fileName  文件名称（需要带后缀，如*.jpg、*.java、*.xml）
     */
    public static void getFile(byte[] bfile, String filePath,String fileName) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try {
            File dir = new File(filePath);
            if(!dir.exists() && !dir.isDirectory()){//判断文件目录是否存在
                dir.mkdirs();
            }
            file = new File(filePath + File.separator + fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bfile);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }





}
