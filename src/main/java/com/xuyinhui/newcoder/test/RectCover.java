/**
 * @author: xu_yh
 * @date: 2019/12/5 16:48
 * @Copyright ©2019 xu_yh. All rights reserved.
 */
package com.xuyinhui.newcoder.test;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * @author: xu_yh
 * @date: 2019/12/5 16:48
 * @version: V1.0
 */
public class RectCover {

    /**
     * 解法一：迭代
     *
     * @param target
     * @return
     */
    public int rectCover(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }

        int n = 1;
        int count = 2;
        int temp = 0;
        while (target > 2) {
            target--;
            temp = count;
            count = n + count;
            n = temp;
        }

        return count;
    }
}