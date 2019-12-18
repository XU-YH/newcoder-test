package com.xuyinhui.newcoder.test;

import java.util.Scanner;

import org.junit.Test;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * @author: yinhui xu
 * @date: 2019/12/17 14:53
 */
public class ReOrderArray {

    @Test
    public void test() {
        int[] array = {2, 4, 6, 1, 3, 5, 7};
        reOrderArray2(array);
        for (int num : array) {
            System.out.print(num + ",");
        }
    }

    /**
     * 解法三：新建一个数组，先把奇数存进去，再把偶数存进去
     *
     * @param array
     */
    public void reOrderArray3(int[] array) {

    }

    /**
     * 解法二：插入算法
     *
     * @param arrray
     */
    public void reOrderArray2(int[] arrray) {
        int length = arrray.length;
        for (int i = 0; i < length - 1; i++) {
            // 从左到右找到第一个偶数
            if (isEven(arrray[i])) {
                int j = i + 1;
                while (j < length) {
                    // 从arr[i]这个偶数的右边找到第一个奇数
                    if (!isEven(arrray[j])) {
                        // 将奇数插入到偶数的位置，偶数整体后移一个位置
                        int temp = arrray[j];
                        for (int i1 = j; i1 > i; i1--) {
                            arrray[i1] = arrray[i1 - 1];
                        }
                        arrray[i] = temp;
                        break;
                    }
                    // 找到最后一位数都没有奇数，说明已排好顺序
                    if (j == length - 1) {
                        return;
                    }
                    j++;
                }

            }
        }
    }

    /**
     * 解法一：冒泡算法
     * 
     * @param array
     */
    public void reOrderArray1(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                // 将最后的第 i+1 个偶数放到最后的第 i+1 个位置
                if (isEven(array[j]) && !isEven(array[j + 1])) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    /**
     * 交换数组两个元素的位置
     *
     * @param array
     * @param j
     * @param i
     */
    private void swap(int[] array, int j, int i) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    /**
     * 判断一个数是否为偶数
     *
     * @param number
     * @return
     */
    private Boolean isEven(int number) {
        return (number & 1) == 0;
    }
}
