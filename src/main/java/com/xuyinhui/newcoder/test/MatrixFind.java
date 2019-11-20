/**
 * @author: xu_yh
 * @date: 2019/11/18 14:32
 * @Copyright ©2019 xu_yh. All rights reserved.
 */
package com.xuyinhui.newcoder.test;

import org.junit.Test;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * @author: xu_yh
 * @date: 2019/11/18 14:32
 * @version: V1.0
 */
public class MatrixFind {

    @Test
    public void test() {
        int[][] arr = { { 1, 2, 8, 9 }, { 4, 7, 10, 13 } };
        // 解法一
        method1(arr, 7);
        // 解法二
        // method2(arr, 7);
    }

    /**
     * 已知二维数组横向和纵向皆为有序，将二维数组横向分割为arr[0].length个一维数组，再对每个一维数组二分查找
     *
     * @param arr
     * @param target
     */
    public void method1(int[][] arr, int target) {
        for (int i = 0; i < arr[0].length; i++) {
            int result = binarySearch(arr[i], target);
            if (result != -1) {
                System.out.println("(" + i + "," + result + ")");
                return;
            }
        }

        System.out.println("数组中不含有该整数");
    }

    /**
     * 以二维数组右上角为起点，数值比目标值大往左移，数值比目标值小往下移，以此往复，直至找到或是超出边界。
     *
     * @param arr
     * @param target
     */
    public void method2(int[][] arr, int target) {
        int leftBorder = 0;
        int bottomBorder = arr.length - 1;
        int x = 0;
        int y = arr[0].length - 1;

        while (x <= bottomBorder && y >= leftBorder) {
            int temp = arr[x][y];
            if (temp == target) {
                System.out.println("(" + x + "," + y + ")");
                return;
            }
            if (target < temp) {
                y -= 1;
                continue;
            }
            x += 1;
        }

        System.out.println("数组中不含有该整数");
    }

    /**
     * 二分查找，返回其索引值
     *
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (right > left) {
            int middle = (left + right) / 2;
            if (target == arr[middle]) {
                return middle;
            }
            if (target > arr[middle]) {
                left = middle + 1;
            }
            if (target < arr[middle]) {
                right = middle - 1;
            }
        }

        return -1;
    }
}