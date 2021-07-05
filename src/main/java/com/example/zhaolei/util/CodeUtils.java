package com.example.zhaolei.util;

import java.util.Calendar;
import java.util.Date;

public class CodeUtils {


    public static void main(String[] args) {
        /*int len = 15;
        char[] pwd = new char[len];
        int i = 0;
        while(i < len) {
            pwd[i] = (char) ('0' + Math.random() * 10);
            i ++;
            pwd[i] = (char) ('a' + Math.random() * 26);
            i ++;
            pwd[i] = (char) ('A' + Math.random() * 26);
            i ++;
        }
        System.out.println(String.valueOf(pwd)); // 7iH8iQ4gI8hT1kT*/

        /*Date date = new Date();
        String s = String.valueOf(date.getTime());
        System.out.println(s);

        String policeCode = "017";
        String substring = policeCode.substring(0, 3);
        System.out.println(substring);*/



        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR_OF_DAY,24);
        Date time = calendar.getTime();
        long time1 = time.getTime();
        System.out.println(time1);
    }
}
