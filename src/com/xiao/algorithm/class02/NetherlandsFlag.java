package com.xiao.algorithm.class02;


import java.util.Arrays;

/**
 * 荷兰国旗问题
 *
 * @author KongXiao
 * @date 2021/12/13
 */
public class NetherlandsFlag {
    /**
     * 给定一个数组 arr，和一个数 num，请把小于 num 的数放在数组的左边，等于 num 的数放在数组的中间，大于num 的数放在数组的右边。
     * 要求额外空间复杂度O(1)，时间复杂度O(N)
     *
     * @param arr
     * @param num
     * @return
     */
    public static int[] partition(int[] arr, int num) {
        int less = -1;
        int more = arr.length;
        int curr = 0;
        while (curr < more) {
            if (arr[curr] < num) {
                // 当前位置和less的下一个位置元素交换
                swap(arr, ++less, curr++);
            } else if (arr[curr] > num) {
                // 当前位置和more的前一个位置元素交换，因为当前位置的元素是从大于区域换过来的，因此 curr 不需要移动
                swap(arr, --more, curr);
            } else {
                curr++;
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 3, 2, 9};
        System.out.println(Arrays.toString(partition(arr, 2)));
    }

}
