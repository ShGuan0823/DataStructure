package com.sg.sort;

import com.sg.common.Tools;

import java.util.Stack;

/**
 * @Description 交换排序
 * @Author ShGuan
 * @Date 2019/6/5 14:55
 **/
public class ExchangeSort {

    /**
     * 冒泡排序
     * @param array 待排序数组
     */
    public static int[] bubbleSort(int[] array) {
        int len = array.length;
        // 是否交换标记
        boolean flag = true;
        // 临时变量
        int temp;
        for (int i = 1; i < len && flag; i++) {
            flag = false;
            for (int j = 0; j < len-i; j++) {
                // 逆序时交换
                if (Tools.comPareTo(array[j], array[j+1]) > 0) {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = true;
                }
            }
        }
        return array;
    }

    /**
     * 快速排序（递归）
     * @param array
     * @return
     */
    public static int[] reQuickSort(int low, int high, int[] array) {
        if (low < high) {
            int pivotIndex = partition(low, high, array);
            // 低子表递归
            reQuickSort(low+1, high, array);
            // 高子表递归
            reQuickSort(low, high-1, array);
        }
        return array;
    }

    public static int[] quickSort(int low, int high, int[] array) {
        int pivot;
        if (low >= high) {
            return null;
        }
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(low);
        stack.push(high);
        while (!stack.empty()) {
            high = stack.pop();
            low = stack.pop();
            pivot = partition(low, high, array);
            if (low < pivot-1) {
                stack.push(low);
                stack.push(pivot-1);
            }
            if (pivot+1 < high) {
                stack.push(pivot+1);
                stack.push(high);
            }
        }
        return array;
    }

    /**
     * 一次快速排序
     * @param low
     * @param high
     * @param array
     * @return
     */
    private static int partition(int low, int high, int[] array) {
        int pivot = array[low];
        while (low < high) {
            // 从尾部向中间扫描, 直到扫描到第一个小于等于支点的记录
            while (low < high && Tools.comPareTo(pivot, array[high]) <= 0) {
                high--;
            }
            if (low < high) {
                // 将比支点记录小的记录向前移动
                array[low] = array[high];
                low++;
            }
            // 从头部向中间扫描, 直到扫描到第一个大于支点的记录
            while (low < high && Tools.comPareTo(pivot, array[low]) > 0) {
                low++;
            }
            if (low < high) {
                // 将比支点记录大的记录向后移动
                array[high] = array[low];
                high--;
            }
        }
        array[low] = pivot;
        return low;
    }



}