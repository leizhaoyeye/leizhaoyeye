package com.example.zhaolei.suanfa;

public class SuanFa4 {


    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     * @param args
     */
    public  static void main(String[] args){
        int[] arr ={12,45,2,1,8,5,33,23,9,20,16,20};

        int target = 32;

        int[] ints = twoSum(arr, target);
        System.out.println("----------------------");
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    //
    public static int[] twoSum(int[] nums, int target ){
        int arr [] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j >= 0; j--) {
                if (i==j){
                    continue;
                }else {
                    if (nums[i]+nums[j]==target){
                        arr[0]=i;
                        arr[1]=j;
                    }
                }
            }
        }
        return arr;
    }
}
