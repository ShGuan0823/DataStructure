package com.sg.sort;

import com.sg.common.tool.Tools;

/**
 * @Description 选择排序
 * @Author ShGuan
 * @Date 2019/6/5 17:45
 **/
public class SelectionSort {

    /**
     * 直接选择排序
     * @param array
     * @return
     */
    public static int[] selectionSort(int[] array) {
        int temp;
        int len = array.length;
        for (int i = 0; i < len-1; i++) {
            int min = i;
            for (int j = i+1; j < len; j++) {
                if (Tools.comPareTo(array[j], array[min]) < 0) {
                    min = j;
                }
            }
            if (min != i) {
                temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
        return array;
    }

}