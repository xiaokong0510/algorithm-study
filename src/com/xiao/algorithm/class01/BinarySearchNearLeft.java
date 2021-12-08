package com.xiao.algorithm.class01;

import com.xiao.algorithm.util.SortUtils;

/**
 * 在一个有序数组中，找>=某个数最左侧的位置
 *
 * @author KongXiao
 * @date 2021/12/7
 */
public class BinarySearchNearLeft {
    public static int nearestIndex(int[] sortedArray, int value) {
        int left = 0;
        int right = sortedArray.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (sortedArray[mid] >= value) {
                index = mid;
                right = mid - 1;
            } else if (sortedArray[mid] < value) {
                left = mid + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] sortedArray = new int[]{2, 4, 10, 10, 13, 13, 17, 21};
        System.out.print("原始数组为：");
        SortUtils.printArray(sortedArray);
        int value = 10;
        System.out.println("目标值为：" + value);
        System.out.println("大于等于目标值最左侧位置是 " + nearestIndex(sortedArray, value));
    }

}
