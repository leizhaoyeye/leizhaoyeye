package com.example.zhaolei;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.function.Consumer;

@Slf4j
public class TestLambda {

    public static void main(String[] args) {
        Comparator<Integer>  com  = (x,y) -> Integer.compare(x,y);
        TreeSet<Integer> treeSet =new TreeSet<>(com);
    }

    //无参，无返回值
    @Test
    public  void test() {
        int a =11;
        Runnable r=()-> System.out.println("Hello Lambda"+a);
        r.run();
    }

    //有参，无返回值
    @Test
    public  void test01() {
        Consumer c =(s)-> System.out.println(s);
        c.accept("哎，太难了---");
    }

    //有参，无返回值
    @Test
    public  void test02() {
        Consumer c =s-> System.out.println(s);
        c.accept("哎，太难了---");
    }


    @Test
    public  void test03() {
        int i =1;
        int aa = (++i)+(++i);
        System.out.println(aa);
    }

    @Test
    public void test04(){
        long start = System.currentTimeMillis();

        Long end =  start+125498512;

        log.info("异步执行执行时间：" + (end - start)/1000+"秒");
    }
}
