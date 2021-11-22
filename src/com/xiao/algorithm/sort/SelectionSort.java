package com.xiao.algorithm.sort;

import com.xiao.algorithm.util.SortUtils;


/**
 * 选择排序
 *
 * @author KongXiao
 * @date 2021/11/4
 */
public class SelectionSort {

    /**
     * 选择排序
     *
     * @param arr 待排序数组
     */
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 0 ~ n-1 找出最小值放在 0 处
        // 1 ~ n-1 找出最小值放在 1 处
        // 2 ~ n-1 找出最小值放在 2 处 ...
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            // 交换
            swap(arr, i, minIndex);
        }
    }

    /**
     * 交换数组中两个元素
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
            selectionSort(arr1);
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
        selectionSort(arr);
        SortUtils.printArray(arr);
    }

}
