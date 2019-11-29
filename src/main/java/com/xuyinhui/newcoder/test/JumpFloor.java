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
    public void test(){
        jumpFloor(0);
    }

    /**
     * 解法一：
     *
     * @param target
     * @return
     */
    public int jumpFloor(int target) {
        if (target <= 0) {
            return 0;
        }

        // count种跳法
        int count = 1;
        // 跳2级的数量
        int n = 1;
        while (target > 2 * n) {

            count++;
            n++;

        }

        return count;
    }
}