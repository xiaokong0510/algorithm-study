package com.xiao.algorithm.class02;

import com.xiao.algorithm.util.SortUtils;

/**
 * 归并排序
 *
 * @author KongXiao
 * @date 2021/12/13
 */
public class MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    /**
     * 在数组arr l -> r上排列有序
     * @param arr
     * @param l
     * @param r
     */
    private static void process(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        // 左组有序
        process(arr, l, mid);
        // 右组有序
        process(arr, mid + 1, r);
        // 合并左右组
        merge(arr, l, mid, r);
    }

    /**
     * 左右组合并并排好序
     *
     * @param arr 待排序数组
     * @param l   左边界
     * @param mid 中点
     * @param r   右边界
     */
    private static void merge(int[] arr, int l, int mid, int r) {
        // 申请一个辅助数组
        int[] help = new int[r - l + 1];
        int index = 0;
        // 左指针
        int p1 = l;
        // 右指针
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            // 谁小就复制谁的值到辅助数组，指针移动一位
            help[index++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 还剩下的值直接全部复制，两个 while只会中一个
        while (p1 <= mid) {
            help[index++] = arr[p1++];
        }
        while (p2 <= r) {
            help[index++] = arr[p2++];
        }
        // 辅助数组的值复制回原数组
        for (int i : help) {
            arr[l++] = i;
        }
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
            mergeSort(arr1);
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
        mergeSort(arr);
        SortUtils.printArray(arr);
    }
}
