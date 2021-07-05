package com.example.zhaolei.suanfa;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;


/**
 * ABA问题的解决
 * 主线程初始值是1 版本是1   干扰线程把值改为2  版本2 ，又改成1 版本3
 * 主线程睡眠回来后去执行跟新操作，更新失败。 因为期望值是1，版本是2.   而干扰线程经过一番操作虽然值还是1，但是版本是3了
 * 所以更新失败 CAS 解决ABA问题
 */
public class CasABADemo02 {
    //AtomicInteger   原子变量
    public static AtomicStampedReference<Integer> a = new AtomicStampedReference(new Integer(1), 1);
    
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("操作线程===>" + Thread.currentThread().getName() + "初始值：" + a.getReference()+"    版本号："+a.getStamp());
                try {
                    //a . get的是期望引用
                    Integer expectReference = a.getReference();
                    //新引用
                    Integer newNum = expectReference + 1;
                    //期望的版本
                    Integer stamp = a.getStamp();
                    //新版本
                    Integer newStamp = a.getStamp() + 1;
                    //主线程休眠1秒钟，让出CPU的执行权
                    Thread.sleep(1000);
                    //这个方法你修改成功会返回true
                    boolean isCASSccuess = a.compareAndSet(expectReference, newNum, stamp, newStamp);
                    System.out.println("操作线程===>" + Thread.currentThread().getName() + "CAS操作：" + isCASSccuess);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "主线程");

        Thread other = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(20);//确保主线程先执行
                    //a 值+1  版本+1
                    a.compareAndSet(a.getReference(), a.getReference() + 1, a.getStamp(), a.getStamp() + 1);
                    System.out.println("操作线程===>" + Thread.currentThread().getName() + ". 【increment】,值：" + a.getReference()+"    版本号："+a.getStamp());
                    // a 值-1  版本+1
                    a.compareAndSet(a.getReference(), a.getReference() - 1, a.getStamp(), a.getStamp() + 1);
                    System.out.println("操作线程===>" + Thread.currentThread().getName() + ". 【increment】,值：" + a.getReference()+"    版本号："+a.getStamp());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "干扰线程");
        thread.start();
        other.start();
    }
}
