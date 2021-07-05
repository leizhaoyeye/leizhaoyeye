package com.example.zhaolei.suanfa;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ReentrantLock  的  最简单的理解
 */
public class parkAndLock {
    /*volatile  int status=0;  //状态码
    Queue parkQueue ;          //队列

    void lock(){
        while (!compareAndSet(0,1)){
            park();
        }
    }

    void unLock(){
        status=0;
        lock_notify();
    }

    void park(){
        //将当前线程加入等待队列
        parkQueue.add(currentThread);
        //将当前线程释放CPU，然后阻塞
        releaseCPU();
    }
    void lock_notify(){
        //得带要唤醒的线程，就是队列的头部线程
        Thread t  = parkQueue.header();
        unLock(t);
    }

    *//**
     *
     * @param expectCount  期望值
     * @param newCount   需要给count赋值的新值
     * @return     boolean
     *//*
      boolean compareAndSet(int expectCount ,int newCount){
        //判断count当前值是否和期望值一致
        if (getCount()==expectCount){
            count=newCount;
            return true;
        }
        return false;
    }*/
}
