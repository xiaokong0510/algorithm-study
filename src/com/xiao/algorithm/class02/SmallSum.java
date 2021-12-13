package com.xiao.algorithm.class02;

import com.xiao.algorithm.util.SortUtils;

/**
 * 小和问题
 *
 * @author KongXiao
 * @date 2021/12/13
 */
public class SmallSum {
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return process(arr, l, mid) + process(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    /**
     * 左右组合并并排好序,同时返回小和
     *
     * @param arr
     * @param l
     * @param mid
     * @param r
     * @return
     */
    private static int merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int index = 0;
        int p1 = l;
        int p2 = mid + 1;
        int res = 0;
        while (p1 <= mid && p2 <= r) {
            // 归并排序的同时求小和，因为右边是排好序的，因此可以直接根据下标求出个数
            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            // 注意只能是arr[p1] < arr[p2，左右数相等时，只能先拷贝右边的数，因为左边的数还没比较完
            help[index++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[index++] = arr[p1++];
        }
        while (p2 <= r) {
            help[index++] = arr[p2++];
        }
        for (int i : help) {
            arr[l++] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = SortUtils.generateRandomArray(maxSize, maxValue);
            int[] arr2 = SortUtils.copyArray(arr1);
            if (smallSum(arr1) != comparator(arr2)) {
                succeed = false;
                SortUtils.printArray(arr1);
                SortUtils.printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

    /**
     * 对数器，暴力法求小和
     *
     * @param arr
     * @return
     */
    public static int comparator(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                res += arr[j] < arr[i] ? arr[j] : 0;
            }
        }
        return res;
    }

}
