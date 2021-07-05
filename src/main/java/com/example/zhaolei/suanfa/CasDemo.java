package com.example.zhaolei.suanfa;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


/**
 * 多线程问题案例
 * 问：每次值不一样，问题出在哪里？
 * a: count++ 的操作其实是由三步操作来完成的（jvm执行引擎）  不是一个原子性操作
 *      1、获取count的值，记做A     2、将A 值+1 记做 B   3、将B 赋值给count
 * 给方法加锁， 给count加锁 都可以，但是存在效率问题
 * 这里用的是CAS  62
 * 直接给第三步加锁
 *      1、获取锁
 *      2、获取count的最新值，记做 lv
 *      3、判断lv是否等于A     ，如果相等，把B赋值给count，返回true,否则返回false
 */
public class CasDemo {

    //总访问量
    volatile static int count=0;

    //模拟的登陆访问方法
    public  static void request() throws InterruptedException {
        //5 毫秒
        TimeUnit.MICROSECONDS.sleep(5);
        //期望值
        /*int expectCount ;
        while (!compareAndSwap(expectCount=getCount(),expectCount+1)){}*/
        count++;
        /*synchronized (Demo01.class){
            count++;
        }*/
    }

    /**
     *
     * @param expectCount  期望值
     * @param newCount   需要给count赋值的新值
     * @return     boolean
     */
    public  static  synchronized  boolean compareAndSwap(int expectCount ,int newCount){
        //判断count当前值是否和期望值一致
        if (getCount()==expectCount){
            count=newCount;
            return true;
        }
        return false;
    }

    //这个方法返回的就是主内存中的count值，因为上面加了volatile
    public static int getCount(){return count;}


    public static void main(String[] args) throws Exception {
        //开始时间
        long startIime =System.currentTimeMillis();
        int threadSize =100;

        //设置栈栏，
        CountDownLatch countDownLatch=new CountDownLatch(threadSize);

        //开启100个线程 模拟100个用户
        for (int i = 0; i < threadSize; i++) {
            Thread thread=new Thread(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    //每个用户访问10次
                    try {
                        for (int j = 0; j < 10; j++) {
                            request();
                        }
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }finally {
                        //就是-1的操作
                        countDownLatch.countDown();
                    }

                }
            });

            thread.start();
        }
        //  await  就是必须值为0才可以执行
        countDownLatch.await();
        long endTime =System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName()+"耗时"+(endTime-startIime)+"     count="+count);
    }

}
