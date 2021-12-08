package com.xiao.algorithm.class01;

import com.xiao.algorithm.util.SortUtils;

/**
 * @author KongXiao
 * @date 2021/12/7
 */
public class FindOneLessValueIndex {

    /**
     * 在无序、相邻元素不相等的数组中返回一个局部最小值的位置
     * 数组无序，同样可以采用二分法
     *
     * @param arr
     * @return
     */
    public static int getLessValueIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        // 最左即为局部最小
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        // 最右即为局部最小
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        // 在区间[1，n-2]开始二分
        int left = 1;
        int right = arr.length - 2;
        int mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] array = new int[]{10, 6, 5, 2, 4, 8, 7, 10, 13, 21};
        System.out.print("原始数组为：");
        SortUtils.printArray(array);
        int index = getLessValueIndex(array);
        System.out.println("index: " + index + ", value: " + array[index]);
    }

}
