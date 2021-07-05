package com.example.zhaolei.suanfa;

import java.util.Arrays;
import java.util.Scanner;


/**
 * 冒泡排序
 */
public class SuanFa1 {
    public static void main(String[] args) {
        System.out.println("输入要排序的值，输入的每个值用逗号隔开:");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] splitStr = s.split(",");
        int[] array  = new int[splitStr.length];
        for (int i = 0; i < array .length; i++) {
            array[i]=Integer.parseInt(splitStr[i]);
        }
        System.out.println("排序前的数组："+ Arrays.toString(array));
        //排序
        sort2(array);
        System.out.println("排序后的数组："+ Arrays.toString(array));

    }

    /**
     * 原始冒泡排序
     * @param array
     */
    private static void sort1(int[] array) {
        //  需要比较length-1次
        for (int i = 0; i < array.length - 1; i++) {
            System.out.println("第"+(i+1)+"次比较");
            for (int j = 0; j <array.length-1-i; j++) {
                int temp=0;
                if (array[j]>array[j+1]){
                    temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
            System.out.println("第"+(i+1)+"次比较的结果是："+Arrays.toString(array));
        }
    }

    /**
     * 优化一：增加标志位 如果有一次循环一个数也没有交换，证明已经排序好了，就打破循环
     * @param array
     */
    private static void sort2(int[] array) {
        //  需要比较length-1次
        for (int i = 0; i < array.length - 1; i++) {
            System.out.println("第"+(i+1)+"次比较");
            boolean flag=true;
            for (int j = 0; j <array.length-1-i; j++) {
                int temp=0;
                if (array[j]>array[j+1]){
                    temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                    flag=false;
                }
            }
            System.out.println("第"+(i+1)+"次比较的结果是："+Arrays.toString(array));
            if (flag){
                System.out.println("用到了逻辑标志位，比较了"+(i+1)+"次");
                break;
            }
        }
    }

    /**
     * 这个比较的次数是和第二个一样的，但是每一次比较的位数会少
     * 就是第一次比较完后，最后一位肯定是最大的，以后就不去比较最后一位了
     * @param array
     */
    private static void sort3(int[] array) {
        // 用来交换的临时数
        int temp = 0;
        // 最后一次交换的下标
        int lastSwapIndex = 0;
        // 无序数组的边界，每次比较比到这里为止
        int arrBoundary = array.length - 1;

        for (int i = 0; i < array.length - 1; i++) {
            System.out.println("第" + (i + 1) + "趟");
            // 优化冒泡排序，增加判断位，有序标记，每一轮的初始是true
            boolean flag = true;
            for (int j = 0; j < arrBoundary; j++) {
                // 找最小数，如果前一位比后一位大，则交换位置
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    // 有元素交换，所以不是有序，标记变为false
                    flag = false;
                    // 最后一次交换元素的位置
                    lastSwapIndex = j;
                }
                System.out.println("  第" + (j + 1) + "次：" + Arrays.toString(array));
            }
            // 把最后一次交换元素的位置赋值给无序数组的边界
            arrBoundary = lastSwapIndex;
            // 说明上面内层for循环中，没有交换任何元素，直接跳出外层循环
            if (flag) {
                break;
            }
        }
    }

}
