/**
 * @author: xu_yh
 * @date: 2019/11/28 9:15
 * @Copyright ©2019 xu_yh. All rights reserved.
 */
package com.xuyinhui.newcoder.test;

import org.junit.Test;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 * 斐波那契数列指的是这样一个数列 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233，377，610，987，1597，2584，4181，6765，10946，17711，28657，46368........
 * 这个数列从第3项开始，每一项都等于前两项之和。
 *
 * @author: xu_yh
 * @date: 2019/11/28 9:15
 * @version: V1.0
 */
public class Fibonacci {

    /**
     * n<=39
     */
    private int[] arr = new int[40];

    @Test
    public void test() {

    }

    /**
     * 解法一：递归实现，因为斐波那契数列是不变的，使用数组（集合也行）存放数列中的数值，从数组中获取数值，减少递归次数
     *
     * @param n
     * @return
     */
    public int fibonacci1(int n) {
        if (n == 0 || arr[n] != 0) {
            return arr[n];
        }
        if (n < 3) {
            arr[n] = 1;
        } else {
            arr[n] = fibonacci1(n - 1) + fibonacci1(n - 2);
        }

        return arr[n];
    }

    /**
     * 解法二：循环实现
     *
     * @param n
     * @return
     */
    public int fibonacci2(int n) {
        int n1 = 1;
        int n2 = 0;
        int sum = 0;

        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        while (n > 1) {
            n--;
            sum = n1 + n2;
            n2 = n1;
            n1 = sum;
        }

        return sum;
    }

}