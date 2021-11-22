package com.xiao.algorithm.sort;


import com.xiao.algorithm.util.SortUtils;

/**
 * 冒泡排序
 *
 * @author KongXiao
 * @date 2021/11/4
 */
public class BubbleSort {

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 索引 0 ~ n-1，依次比较相邻两个数，谁大谁往右移，搞定 n-1 的位置
        // 索引 0 ~ n-2，依次比较相邻两个数，谁大谁往右移，搞定 n-2 的位置
        // 索引 0 ~ n-3，依次比较相邻两个数，谁大谁往右移，搞定 n-3 的位置...
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }


    /**
     * 使用对数器进行测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = SortUtils.generateRandomArray(maxSize, maxValue);
            int[] arr2 = SortUtils.copyArray(arr1);
            bubbleSort(arr1);
            SortUtils.comparator(arr2);
            if (!SortUtils.isEqual(arr1, arr2)) {
                succeed = false;
                SortUtils.printArray(arr1);
                SortUtils.printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = SortUtils.generateRandomArray(maxSize, maxValue);
        SortUtils.printArray(arr);
        bubbleSort(arr);
        SortUtils.printArray(arr);
    }
}
