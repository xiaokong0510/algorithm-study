package com.xiao.algorithm.class02;

import com.xiao.algorithm.util.SortUtils;

/**
 * @author KongXiao
 * @date 2021/12/8
 */
public class GetMax {
    public static int getMax(int[] arr) {
        // 调用 process 方法，获取 arr在 0~arr.length - 1的最大值
        return process(arr, 0, arr.length - 1);
    }

    /**
     * 获取 arr 在指定范围的最大值
     *
     * @param arr
     * @param left  起始位置
     * @param right 终止位置
     * @return
     */
    private static int process(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }
        int mid = left + ((right - left) >> 1);
        // 在[left,mid]、[mid+1,right]区间分别找到最大值
        int leftMax = process(arr, left, mid);
        int rightMax = process(arr, mid + 1, right);
        // 返回这两个最大值中较大的
        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        int[] arr = SortUtils.generateRandomArray(10, 100);
        SortUtils.printArray(arr);
        System.out.println(getMax(arr));
    }

}

