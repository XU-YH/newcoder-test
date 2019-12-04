/**
 * @author: xu_yh
 * @date: 2019/12/4 15:59
 * @Copyright ©2019 xu_yh. All rights reserved.
 */
package com.xuyinhui.newcoder.test;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法
 *
 * @author: xu_yh
 * @date: 2019/12/4 15:59
 * @version: V1.0
 */
public class JumpFloorII {

    /**
     * 解法一：迭代比递归好
     * 数学问题，f(n) = f(n-1) + f(n-2) + f(n-3) + ... + f(1)
     * f(n-1) = f(n-2) + f(n-3) + ... + f(1) => f(n) = 2*f(n-1)
     *
     * @param target
     * @return
     */
    public int jumpFloorIi(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }

        int result = 1;
        int n = 1;
        while (n < target) {
            n++;
            result = 2 * result;
        }

        return result;
    }

}