package com.xiao.algorithm.class02;

import com.xiao.algorithm.util.SortUtils;

/**
 * 快排
 *
 * @author KongXiao
 * @date 2021/12/13
 */
public class QuickSort {

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 快速排序
     *
     * @param arr 待排序的数组
     * @param l   左边界
     * @param r   右边界
     */
    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            // [l,r]上随机取一个元素作为划分值
            swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
            // 以 arr[r]作为划分值，将数组进行划分成三个部分，左侧<划分值、中间==划分值、右侧>划分值
            // 将中间区域的左右边界索引存入 p 中
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    /**
     * 将数组进行划分成三个部分，左侧<划分值、中间==划分值、右侧>划分值，划分值取最右的元素，
     *
     * @param arr
     * @param l
     * @param r
     * @return 中间区域的左右边界索引组成的数组
     */
    private static int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            // 以 arr[r]作为划分值，将数组进行划分成三个部分，左侧<划分值、中间==划分值、右侧>划分值
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        // 将划分值与右区间的第一个元素交换，arr的[l,r]区间划分完成
        swap(arr, more, r);
        // 返回中间区域的左右边界索引组成的数组，因为将最后一位上的划分值移动到了中间去取，因此右边界为more
        return new int[]{less + 1, more};
    }

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
            quickSort(arr1);
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
        quickSort(arr);
        SortUtils.printArray(arr);
    }
}
