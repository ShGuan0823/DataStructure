package com.sg.common.domain;

/**
 * @Description 链表节点
 * @Author ShGuan
 * @Date 2019/6/7 15:39
 **/
public class LinkNode {

    /**
     * 数据
     */
    private Object data;

    /**
     * 后继节点引用
     */
    private LinkNode next;

    /**
     * 无参构造函数
     */
    public LinkNode() {
        this(null, null);
    }

    /**
     * 一个参数构造函数
     * @param data
     */
    public LinkNode(Object data) {
        this(data, null);
    }

    /**
     * 两个参数构造函数
     * @param data
     * @param next
     */
    public LinkNode(Object data, LinkNode next) {
        this.data = data;
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public LinkNode getNext() {
        return next;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setNext(LinkNode next) {
        this.next = next;
    }
}