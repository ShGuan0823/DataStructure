package com.sg.common.domain.List;

import com.sg.common.domain.IList;

/**
 * @Description线性表顺序存储实现
 * @Author ShGuan
 * @Date 2019/6/7 15:23
 **/
public class MyList implements IList {

    /**
     * 存储空间
     */
    private Object[] listElem;

    /**
     * 线性表当前长度
     */
    private int curLen;

    public MyList(int maxSize) {
        curLen = 0;
        listElem = new Object[maxSize];
    }

    @Override
    public void clear() {
        curLen = 0;
    }

    @Override
    public boolean isEmpty() {
        return curLen == 0;
    }

    @Override
    public int length() {
        return curLen;
    }

    @Override
    public Object get(int i) {
        if (i < 0 || i > curLen - 1) {
            throw new ArrayIndexOutOfBoundsException("不存在第" + i + "个元素");
        }
        return listElem[i];
    }

    @Override
    public void insert(int i, Object object) {
        if (curLen == listElem.length) {
            throw new ArrayIndexOutOfBoundsException("顺序表已满");
        }
        if (i < 0 || i > curLen) {
            throw new ArrayIndexOutOfBoundsException("插入位置不合法");
        }
        for (int j = curLen; j > i; j--) {
            listElem[j] = listElem[j-1];
        }
        listElem[i] = object;
        curLen++;
    }

    @Override
    public void remove(int i) {
        if (i < 0 || i > curLen - 1) {
            throw new ArrayIndexOutOfBoundsException("删除位置不合法");
        }
        for (int j = i; j < curLen - 1; j++) {
            listElem[j] = listElem[j+1];
        }
        curLen--;
    }

    @Override
    public int indexOf(Object object) {
        int j = 0;
        while (j < curLen && !listElem[j].equals(object)) {
            j++;
        }
        if (j < curLen) {
            return j;
        } else {
            return -1;
        }
    }

    @Override
    public void display() {
        for (int i = 0; i  < curLen; i++) {
            System.out.print(listElem[i] + " ");
        }
        // 换行
        System.out.println();
    }
}