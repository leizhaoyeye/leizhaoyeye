package com.example.zhaolei;

import com.example.zhaolei.model.entity.Student;
import com.example.zhaolei.util.EntityToArrayUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.*;


/**
 * List<对象>  转 string 类型的二维数据
 * 用到这三个工具类  Base \ EntityToArrayUtil  GenericsUtils
 */
@Slf4j
public class ListToString {
    public static void main(String[] args) {

        List<Student>  list  =new ArrayList();
        list.add(new Student(0,"赵磊","男", "2020-08-10 14:01:00","数字经济","山西省太原市"));
        list.add(new Student(1,"赵敏","女", "2020-08-10 14:01:00","风暴中心","山西省太原市"));
        list.add(new Student(2,"赵高","男", "2020-08-10 14:01:00","风暴中心","山西省太原市"));
        list.add(new Student(3,"赵璐","女", "2020-08-10 14:01:00","风暴中心","山西省太原市"));
        list.add(new Student(4,"王叶","女", "2020-08-10 14:01:00","数字经济","山西省太原市"));
        list.add(new Student(5,"王德","男", "2020-08-10 14:01:00","数字经济","山西省太原市"));
        list.add(new Student(6,"王菲","女", "2020-08-10 14:01:00","数字经济","山西省太原市"));

        String[] variable = {"id", "name","sex", "birthday","department", "address"};
        //String[] variable = {"COMM_CERT_NAME", "COLL_TIME","MOB", "UPD_TIME","CRED_NUM", "USER_STAT_STAT_NAME", "OPEOR_DESIG","USER_NAME", "COMM_CERT_CODE"};
        Object[][] data = EntityToArrayUtil.toArray(list, variable);
        String[][] result =new String[data.length][variable.length];
        for (int j = 0; j < data.length; j++) {
            for (int k = 0; k < variable.length; k++) {
                System.out.print(data[j][k]+" ");
                result[j][k]=data[j][k].toString();
            }
            System.out.println();
        }
        System.out.println("------分------割------线------");
        /*int i=0;
        for (String x[]:result) {
            i++;
            int j=0;
            for (String y:x) {
                j++;
                if(i==result.length&&j==x.length){
                    System.out.print(y);
                }else{
                    System.out.print(y+" ");
                }
            }
            System.out.println();
        }

        System.out.println(data.toString());*/


        long start = System.currentTimeMillis();

        Long end =  start+125498512;

        log.info("异步执行执行时间：" + (end - start)/1000+"秒");
    }
}
