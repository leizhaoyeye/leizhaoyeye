package com.example.zhaolei.suanfa;

import java.util.Arrays;
import java.util.Random;


/**
 * 快速排序
 * 快速排序说白了----给基准数据找其正确索引位置的过程
 */
public class SuanFa3 {
    public static void main(String[] args) {
        int[] intarr = random();
        System.out.println("排序之前的数组: " + Arrays.toString(intarr));
        //   传入数组、  开始的索引  、结束的索引
        quickSort(intarr, 0, intarr.length - 1);
        System.out.println("排序之后的数组: " + Arrays.toString(intarr));
    }

    private static void quickSort(int[] array, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            // 找基准元素先
            int baseIndex = divide(array, startIndex, endIndex);
            // 递归调用,对分隔后的左边数组快速排序
            quickSort(array, startIndex, baseIndex - 1);
            // 递归调用,对分隔后的右边数组快速排序
            quickSort(array, baseIndex + 1, endIndex);
        } else {
            return;
        }
    }

    public static int divide(int[] array, int startIndex ,int endIndex){
        // 用数组的第一个元素作为起始元素
        int base = array[startIndex];
        int i = startIndex;
        int j = endIndex;
        while (i != j) {
            // 从右向左寻找第一个小于基准数的值
            while (i < j && array[j] > base) {
                j--;
            }
            // 从左向右寻找第一个大于基准数的值
            while (i < j && array[i] <= base) {
                i++;
            }
            // 交换位置
            if (i < j) {
                swap(array, i, j);
            }
        }
        // 指针i 与指针j 相遇，把重合点的元素与基准元素交换位置
        array[startIndex] = array[i];
        array[i] = base;
        // 返回分隔点所在的位置
        return i;
    }

    /**
     * 交换i 与 j 位置的值
     *
     * @param array
     * @param i
     * @param j
     */
    private static void swap(int[] array, int i, int j) {
        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
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
