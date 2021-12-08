package com.xiao.algorithm.class01;

import com.xiao.algorithm.util.SortUtils;

/**
 * 异或运算
 *
 * @author KongXiao
 * @date 2021/12/8
 */
public class ExclusiveOr {
    /**
     * 一个数组中有一种数出现了奇数次，其他数都出现了偶数次，找到这个数
     * 从头异或到尾，偶数次出现的数自己异或等0，剩下的就是出现了奇数次的数
     *
     * @param arr
     */
    public static int findOddTimesNum1(int[] arr) {
        int res = 0;
        for (int cur : arr) {
            res ^= cur;
        }
        return res;
    }

    /**
     * 一个数组中有两种数出现了奇数次，其他数都出现了偶数次，找到这两个数
     *
     * @param arr
     */
    public static int[] findOddTimesNum2(int[] arr) {
        int res1 = 0;
        // 从头异或到尾，得到了这两个数的异或 res1 = a^b
        for (int cur : arr) {
            res1 ^= cur;
        }
        int res2 = 0;
        // a、b 不相等，那么 a^b≠0， a和b的某一位肯定不相同，要么a等于1，b等于0，要么a等于0，b等于1
        // 提取最右侧的 1，假设是第k位，这一位置上a、b不一样
        // 再设置一个变量 res2，再次遍历，res2只和第k位是1的数异或，那么在第二次遍历之后，res2就是a或b中的一个。res1^res2就是另一个
        int rightOne = res1 & (~res1 + 1);
        for (int cur : arr) {
            if ((cur & rightOne) != 0) {
                res2 ^= cur;
            }
        }
        return new int[]{res2, (res1 ^ res2)};
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 7;

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a);
        System.out.println(b);

        int[] arr1 = {3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1};
        System.out.println(findOddTimesNum1(arr1));
        int[] arr2 = {4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2};
        SortUtils.printArray(findOddTimesNum2(arr2));

    }
}
