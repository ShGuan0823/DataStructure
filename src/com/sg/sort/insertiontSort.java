package com.sg.sort;

/**
 * @Description 插入排序
 * @Author ShGuan
 * @Date 2019/6/4 23:58
 **/
public class insertiontSort {

    /**
     * 直接插入排序（不带监视哨）
     * @param array 待排序数组
     */
    public static void insertionSort(int[] array) {
        int len = array.length;
        int i, j, temp;
        // n-1
        for (i = 1; i < len; i++) {
            // 待插入数据
            temp = array[i];
            // 从后向前遍历已插入数据
            for (j = i -1; j >= 0 && comPareTo(temp, array[j]) < 0; j--) {
                // 比array[i]大的记录后移
                array[j+1] = array[j];
            }
            // 插入array[i]
            array[j+1] = temp;
        }

    }

    /**
     * 直接插入排序（带监视哨）
     * @param array 待排序数组(从下标为1开始存放，下标为0为监视哨)
     */
    public static void insertionSortWithGuard(int[] array) {
        int len = array.length;
        int i, j;
        for (i = 1; i < len; i++) {
            // 监视哨
            array[0] = array[i];
            // 不需要坐数组越界控制， 当j为0时，自动退出循环
            for (j = i-1; comPareTo(array[0], array[j]) < 0; j--) {
                // 比array[i]大的记录后移
                array[j+1] = array[j];
            }
            // 插入array[i]
            array[j+1] = array[0];
        }
    }


    /**
     * 比较两个数字大小
     * @param num 第一个数
     * @param another 第二个数
     * @return 小于 -1  等于 0  大于 1
     */
    public static int comPareTo(int num, int another) {
        return (num < another ? -1 : (num == another ? 0 : 1));
    }

}