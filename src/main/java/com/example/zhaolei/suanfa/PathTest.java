package com.example.zhaolei.suanfa;

public class PathTest {


    public static void main(String[] args) {


        System.out.println(PathTest.class.getResource("").getPath());
        System.out.println(PathTest.class.getResource(".").getPath());
        System.out.println(PathTest.class.getResource("../").getPath());
        System.out.println(PathTest.class.getResource("/").getPath());
        System.out.println(PathTest.class.getClassLoader().getResource("").getPath());
        System.out.println(PathTest.class.getClassLoader().getResource(".").getPath());

        System.out.println("-------------分-------------割-------------线-------------");
        System.out.println(Thread.currentThread().getContextClassLoader().getResource("static").getPath());
        System.out.println(Thread.currentThread().getContextClassLoader().getResource("").getPath());

    }
}
