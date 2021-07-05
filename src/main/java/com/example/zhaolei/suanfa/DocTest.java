package com.example.zhaolei.suanfa;


import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class DocTest {


    public static void main(String[] args) throws FileNotFoundException {
        Map map=new HashMap();
        map.put("approval_unit","省厅");
        map.put("approval_time",new Date().toString());
        map.put("applicant_unit","********单位");
        map.put("applicant","张三");


        map.put("case_state","2");
        map.put("case_id","A1401092000002019111899");
        map.put("query_reason","赵磊**");
        map.put("content","赵磊");
        getBuild(map,"D:/bbb.doc");
    }


    public static void getBuild(Map<String, String> contentMap, String exportFile) throws FileNotFoundException {

        String path = Thread.currentThread().getContextClassLoader().getResource("static/template.doc").getPath();
        System.out.println(path);

        File file = new File(path);

        InputStream inputStream = new FileInputStream(file);


        //InputStream inputStream = DocTest.class.getClassLoader().getResourceAsStream(tmpFile);
//        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(tmpFile);
        HWPFDocument document = null;
        try {
            document = new HWPFDocument(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 读取文本内容
        Range bodyRange = document.getRange();
        // 替换内容
        for (Map.Entry<String, String> entry : contentMap.entrySet()) {
            bodyRange.replaceText("${" + entry.getKey() + "}", entry.getValue());
        }

        //导出到文件
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            document.write(byteArrayOutputStream);
            OutputStream outputStream = new FileOutputStream(exportFile);
            outputStream.write(byteArrayOutputStream.toByteArray());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
