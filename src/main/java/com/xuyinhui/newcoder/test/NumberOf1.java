/**
 * @author: xu_yh
 * @date: 2019/12/6 16:30
 * @Copyright ©2019 xu_yh. All rights reserved.
 */
package com.xuyinhui.newcoder.test;

import org.junit.Test;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * @author: xu_yh
 * @date: 2019/12/6 16:30
 * @version: V1.0
 */
public class NumberOf1 {

    @Test
    public void test() {
        System.out.println(numberOf1(3));
    }

    /**
     * 解法一：
     *
     * @param n
     * @return
     */
    public int numberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}