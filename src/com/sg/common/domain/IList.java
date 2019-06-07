package com.sg.common.domain;


/**
 * @Description 线性表顺序存储
 * @Author ShGuan
 * @Date 2019/6/7 15:14
 **/
public interface IList {

    /**
     * 清空
     */
    void clear();

    /**
     * 判空
     * @return 空 true | 非空 false
     */
    boolean isEmpty();

    /**
     * 获得线性表长度
     * @return
     */
    int length();

    /**
     * 获取元素
     * @param i
     * @return
     */
    Object get(int i) throws Exception;

    /**
     * 插入
     * @param i
     * @param object
     */
    void insert(int i, Object object) throws Exception;

    /**
     * 删除
     * @param i
     */
    void remove(int i) throws Exception;

    /**
     * 查找
     * @param object
     * @return
     */
    int indexOf(Object object);

    /**
     * 输出
     */
    void display();

}