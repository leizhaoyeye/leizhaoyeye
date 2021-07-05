package com.example.zhaolei.suanfa;

import java.util.concurrent.atomic.AtomicInteger;


/**
 *ABA问题的模拟
 */
public class CasABADemo {
    //AtomicInteger   原子变量
    public static AtomicInteger a =new AtomicInteger(1);

    public static void main(String[] args) {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("操作线程===>"+Thread.currentThread().getName()+"初始值："+a.get());
                try {
                    int expectNum=a.get();
                    int newNum=expectNum+1;
                    Thread.sleep(1000);//主线程休眠1秒钟，让出CPU的执行权
                    //这个方法你修改成功会返回true
                    boolean isCASSccuess = a.compareAndSet(expectNum, newNum);
                    System.out.println("操作线程===>"+Thread.currentThread().getName()+"CAS操作："+isCASSccuess);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"主线程");

        Thread other=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(20);//确保主线程先执行
                    a.incrementAndGet();//a+1   a=2
                    System.out.println("操作线程===>"+Thread.currentThread().getName()+". 【increment】,值："+a.get());
                    a.decrementAndGet();// a-1 a=1
                    System.out.println("操作线程===>"+Thread.currentThread().getName()+". 【increment】,值："+a.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"干扰线程");
        thread.start();
        other.start();
    }
}
