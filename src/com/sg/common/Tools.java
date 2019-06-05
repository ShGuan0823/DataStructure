package com.sg.common;

/**
 * @Description TODO
 * @Author ShGuan
 * @Date 2019/6/5 14:07
 **/
public class Tools {

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