package com.xuyinhui.newcoder.test;

import org.junit.Test;

/**
 * 快速排序
 *
 * @author: yinhui xu
 * @date: 2019/12/17 16:43
 */
public class QuickSort {

    @Test
    public void test() {
        int[] arr = {13, 7, 5, 23, 9, 10, 11, 18};
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + ", ");
        }

    }

    /**
     * 快速排序 快速排序是交换排序中的一种，是排序算法中速度最快的，平均时间复杂度为O（nlogn)。
     *
     * @param arr
     *            数组
     * @param left
     *            数组左指针
     * @param right
     *            数组右指针
     */
    private void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = getPivot(arr, left, right);
        // 可以简单的选择最后一个元素作为基准值
        // int pivot = arr[right];
        int i = left;
        int j = right;
        while (true) {
            while (i < j && arr[i] <= pivot) {
                i++;
            }
            while (i < j && arr[j] >= pivot) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            } else {
                break;
            }
        }
        swap(arr, i, right);
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

    /**
     * 三数中值分割法，选取基准值（枢纽元），除获取枢纽元外，还将枢纽元放到数组的最后，为的是基准值和数组其他值隔离开。 使用三数中值分割法可使性能提高5%
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private int getPivot(int[] arr, int left, int right) {
        int center = (left + right) / 2;
        if (arr[left] > arr[center]) {
            swap(arr, left, center);
        }
        if (arr[left] > arr[right]) {
            swap(arr, left, right);
        }
        if (arr[center] > arr[right]) {
            swap(arr, center, right);
        }
        swap(arr, center, right);

        return arr[right];
    }

    /**
     * 交换数组中两个元素的值
     *
     * @param arr
     * @param index1
     * @param index2
     */
    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
