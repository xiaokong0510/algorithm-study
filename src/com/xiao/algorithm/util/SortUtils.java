package com.xiao.algorithm.util;

import java.util.Arrays;
import java.util.Random;

/**
 * 验证排序算法的工具类
 *
 * @author KongXiao
 * @date 2021/11/22
 */
public class SortUtils {

    /**
     * 比较器
     *
     * @param arr
     */
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    /**
     * 产生一个随机数组
     *
     * @param maxSize  数组元素个数
     * @param maxValue 数组元素最大值
     * @return
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        Random random = new Random();
        int[] arr = new int[random.nextInt(maxSize) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (random.nextInt(maxValue) + 1) - (random.nextInt(maxValue));
        }
        return arr;
    }

    /**
     * 复制数组
     *
     * @param arr
     * @return
     */
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return new int[0];
        }
        int[] res = new int[arr.length];
        System.arraycopy(arr, 0, res, 0, arr.length);
        return res;
    }

    /**
     * 判断两个数组是否相等
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean isEqual(int[] arr1, int[] arr2) {
        return Arrays.equals(arr1, arr2);
    }

    /**
     * 打印数组
     *
     * @param arr
     */
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
