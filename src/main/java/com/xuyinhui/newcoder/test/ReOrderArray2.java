package com.xuyinhui.newcoder.test;

import java.util.Scanner;

/**
 * 题目描述 输入一个无序整数数组，调整数组中数字的顺序， 所有偶数位于数组的前半部分，使得所有奇数位于数组的后半部分。
 * 要求时间复杂度为O(n)。
 * 输入描述: 给定无序数组。 长度不超过1000000。
 * 输出描述:
 * 所有偶数位于数组的前半部分，所有奇数位于数组的后半部分。 如果有多个答案可以输出任意一个正确答案。
 * 示例1 输入 2 4 5 7 8 1 输出  2 4 8 7 5 1
 *
 * @author: yinhui xu
 * @date: 2019/12/18 11:39
 */
public class ReOrderArray2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strArray = sc.nextLine().split(" ");
        int length = strArray.length;

        int jj = 0;
        f:
        for (int i = 0; i < length; i++) {
            if (!isEven(Integer.parseInt(strArray[i]))) {
                int j = i + 1;
                if (jj != 0) {
                    j = jj;
                }
                while (j < length) {
                    if (isEven(Integer.parseInt(strArray[j]))) {
                        jj = j;
                        String temp = strArray[i];
                        strArray[i] = strArray[j];
                        strArray[j] = temp;
                        break;
                    }
                    if (j == length - 1) {
                        break f;
                    }
                    j++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int ii = 0; ii < length; ii++) {
            sb.append(strArray[ii]);
            if (ii != length - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    /**
     * 判断一个数是否为偶数
     *
     * @param number
     * @return
     */
    private static Boolean isEven(int number) {
        return (number & 1) == 0;
    }
}
