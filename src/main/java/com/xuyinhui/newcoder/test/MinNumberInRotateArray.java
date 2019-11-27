/**
 * @author: xu_yh
 * @date: 2019/11/26 16:58
 * @Copyright ©2019 xu_yh. All rights reserved.
 */
package com.xuyinhui.newcoder.test;

import org.junit.Test;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * @author: xu_yh
 * @date: 2019/11/26 16:58
 * @version: V1.0
 */
public class MinNumberInRotateArray {

    @Test
    public void test() {
        // int[] array = { 3, 4, 5, 1, 2 };
        int[] array = {1, 0};
        System.out.println(minNumberInRotateArray2(array));
    }

    /**
     * 解法一：原数组旋转过去的第一个元素一定比原数组的第一个数组大或等于
     *
     * @param array
     * @return
     */
    public int minNumberInRotateArray1(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                return array[i];
            }
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            }
        }

        return 0;
    }

    /**
     * 解法二：二分法
     *
     * @param array
     * @return
     */
    public int minNumberInRotateArray2(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int left = 0;
        int right = array.length - 1;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (array[mid] > array[right]) {
                left = mid + 1;
                continue;
            }
            if (array[mid] == array[right]) {
                right--;
                continue;
            }
            // 注意：在{1,0,1,1,1}情况下，right = mid - 1 会出现漏掉mid就是最小值的情况
            right = mid;
        }

        return array[left];
    }

}