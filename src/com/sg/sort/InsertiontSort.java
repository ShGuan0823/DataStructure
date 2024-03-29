package com.sg.sort;

import com.sg.common.tool.Tools;

/**
 * @Description 插入排序
 * @Author ShGuan
 * @Date 2019/6/4 23:58
 **/
public class InsertiontSort {

    /**
     * 直接插入排序（不带监视哨）
     * @param array 待排序数组
     */
    public static int[] insertionSort(int[] array) {
        int len = array.length;
        int i, j, temp;
        // n-1
        for (i = 1; i < len; i++) {
            // 待插入数据
            temp = array[i];
            // 从后向前遍历已插入数据
            for (j = i -1; j >= 0 && Tools.comPareTo(temp, array[j]) < 0; j--) {
                // 比array[i]大的记录后移
                array[j+1] = array[j];
            }
            // 插入array[i]
            array[j+1] = temp;
        }
        return array;
    }

    /**
     * 直接插入排序（带监视哨）
     * @param array 待排序数组(从下标为1开始存放，下标为0为监视哨)
     */
    public static int[] insertionSortWithGuard(int[] array) {
        int len = array.length;
        int[] array2 = new int[len+1];
        int i, j;
        for (int m = 0; m < len; m++) {
            array2[m+1] = array[m];
        }
        for (i = 1; i < len; i++) {
            // 监视哨
            array2[0] = array2[i];
            // 不需要坐数组越界控制， 当j为0时，自动退出循环
            for (j = i-1; Tools.comPareTo(array2[0], array2[j]) < 0; j--) {
                // 比array[i]大的记录后移
                array2[j+1] = array2[j];
            }
            // 插入array[i]
            array2[j+1] = array2[0];
        }
        return array2;
    }

    /**
     * 希尔排序
     * @param array 待排序数组
     * @param incremental 增量
     */
    public static int[] shellSort(int[] array, int[] incremental) {
        int arrayLen = array.length;
        int increLen = incremental.length;
        int i, j, temp;
        for (int k = 0; k < increLen; k++) {
            // 增量
            int ink = incremental[k];
            for (i = ink; i < arrayLen; i++) {
                // 在子表内进行直接插入排序
                temp = array[i];
                for (j = i - ink; j >= 0 && Tools.comPareTo(temp, array[j]) < 0; j -= ink) {
                    array[j+ink] = array[j];
                }
                array[j+ink] = temp;
            }
        }
        return array;
    }

}