package com.example.zhaolei.suanfa;

import java.text.ParseException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Test02 {




    public static void main(String[] args) throws InterruptedException {
/*        Timer t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        }, 100, 1000);*/
        System.out.println("------------start ");

        new Thread(()->{
            try {
                Thread.sleep(1000*60);
                System.out.println("申请码失效执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println("------------end");

    }

/*    public static void main(String args[]) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try {
                    System.out.println("开始定时任务");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    timer.cancel();
                    System.out.println("结束");
                }
            }
        };
    }*/
}