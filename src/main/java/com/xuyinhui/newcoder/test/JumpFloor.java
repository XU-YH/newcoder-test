/**
 * @author: xu_yh
 * @date: 2019/11/29 15:59
 * @Copyright ©2019 xu_yh. All rights reserved.
 */
package com.xuyinhui.newcoder.test;

import org.junit.Test;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * @author: xu_yh
 * @date: 2019/11/29 15:59
 * @version: V1.0
 */
public class JumpFloor {

    @Test
    public void test() {
        jumpFloor(2);
    }

    /**
     * 解法一：迭代
     *
     * @param target
     * @return
     */
    public int jumpFloor(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }

        int count = 0;
        int jump1 = 1;
        int jump2 = 0;
        for (int i = 1; i <= target; i++) {
            count = jump1 + jump2;
            jump2 = jump1;
            jump1 = count;
        }

        return count;
    }
}