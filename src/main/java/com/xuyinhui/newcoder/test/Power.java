/**
 * @author: xu_yh
 * @date: 2019/12/9 13:45
 * @Copyright ©2019 xu_yh. All rights reserved.
 */
package com.xuyinhui.newcoder.test;

import org.junit.Test;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 *
 * @author: xu_yh
 * @date: 2019/12/9 13:45
 * @version: V1.0
 */
public class Power {

    @Test
    public void test() throws Exception {
        System.out.println(power2(3, 7));
    }

    /**
     * 解法一：Math类方法
     *
     * @param base
     * @param exponent
     * @return
     */
    public double power(double base, int exponent) {

        return Math.pow(base, exponent);
    }

    /**
     * 解法二：
     *
     * @param base
     * @param exponent
     * @return
     */
    public double power2(double base, int exponent) throws Exception {
        int n = exponent;
        double result = 1;
        double base1 = base;
        if (exponent < 0) {
            if (base == 0) {
                throw new Exception("分母不能为0");
            }
            n = -n;
        }
        if (exponent == 0) {
            return 1;
        }

        while (n != 0) {
            if ((n & 1) == 1) {
                result *= base;
            }
            // 快速幂
            base *= base;
            n = n >> 1;
        }

        return exponent > 0 ? result : 1 / result;
    }
}