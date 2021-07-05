package com.example.zhaolei.suanfa;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SuanFa2 {
    public static void main(String[] args) {
        //生成一个随机数组
        int []  arry =random();
        System.out.println("生成的随机数组是："+Arrays.toString(arry));
        Arrays.sort(arry);
        System.out.println("对随机数组进行排序后：："+Arrays.toString(arry));

        System.out.println("请输入你要进行查找的值(0-99)： ");
        Scanner input = new Scanner(System.in);
        int aim = input.nextInt();
        // 使用二分法查找
        int index = binarySearch(arry, aim);
        System.out.println("查找的值的索引位置： " + index);
    }

    /**
     * 二分法查找  ---循环的方式实现
     *
     * @param arry 要查找的数组
     * @param aim 要查找的值
     * @return 返回值，成功返回索引，失败返回-1
     */
    private static int binarySearch(int[] arry, int aim) {
        //数组最小索引值
        int left =0;
        //数组最大索引值
        int  right =arry.length-1;
        int mid;
        while (left<=right){
            mid=(left+right)/2;
            if (aim<arry[mid]){
                right=mid-1;
            }else if (aim>arry[mid]){
                left=mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 生成一个随机数组：长度随机 值随机
     * @return
     */
    private static int[] random() {
        Random random = new Random();
        int anInt = random.nextInt(6)+5;
        int[] array = new int[anInt];
        for (int i = 0; i < array.length; i++) {
            array[i]=new Random().nextInt(100);
        }
        return array;
    }
}
