package com.xiao.algorithm.class01;

import com.xiao.algorithm.util.SortUtils;

/**
 * 二分查找
 * 在一个有序数组中，找某个数是否存在
 *
 * @author KongXiao
 * @date 2021/12/7
 */
public class BinarySearchExist {

    /**
     * 搜索一个数，如果存在，返回其索引，否则返回 -1
     *
     * @param sortedArray
     * @param target
     * @return
     */
    public static int binarySearch(int[] sortedArray, int target) {
        if (sortedArray == null || sortedArray.length == 0) {
            return -1;
        }
        // 搜索区间为 [left, right]
        int left = 0;
        int right = sortedArray.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (sortedArray[mid] == target) {
                return mid;
            } else if (sortedArray[mid] > target) {
                right = mid - 1;
            } else if (sortedArray[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] sortedArray = new int[]{2, 4, 8, 10, 13, 17, 21};
        System.out.print("原始数组为：");
        SortUtils.printArray(sortedArray);
        int target = 2;
        int target2 = 20;
        System.out.println("是否包含元素：" + target + " " + binarySearch(sortedArray, target));
        System.out.println("是否包含元素：" + target2 + " " + binarySearch(sortedArray, target2));
    }
}
