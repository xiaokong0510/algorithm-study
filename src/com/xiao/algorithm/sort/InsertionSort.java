package com.xiao.algorithm.sort;

import com.xiao.algorithm.util.SortUtils;


/**
 * 插入排序
 *
 * @author KongXiao
 * @date 2021/11/22
 */
public class InsertionSort {

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 索引 1 处的元素与前面的数依次比较，小就往前移动，保证索引 0 ~ 1 有序；
        // 索引 2 处的元素与前面的数依次比较，小就往前移动，保证索引 0 ~ 2 有序；
        // 索引 3 处的元素与前面的数依次比较，小就往前移动，保证索引 0 ~ 3 有序；
        // ...
        // 索引 n-1 处的元素依次与前面的数比较，保证索引 0 ~ n-1 有序；
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
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
            insertionSort(arr1);
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
        insertionSort(arr);
        SortUtils.printArray(arr);
    }
}
