package com.sg.common.domain.Node;

/**
 * @Description 双向链表结点
 * @Author ShGuan
 * @Date 2019/6/7 17:10
 **/
public class DuLNode{

    /**
     * 数据
     */
    private Object data;

    /**
     * 前驱结点引用
     */
    private DuLNode prior;

    /**
     * 后继结点引用
     */
    private DuLNode next;

    /**
     * 无参构造函数
     */
    public DuLNode(){
        this(null);
    }

    /**
     * 传参为数据构造函数
     */
    public DuLNode(Object data) {
        this.data = data;
        this.prior = null;
        this.next = null;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public DuLNode getPrior() {
        return prior;
    }

    public void setPrior(DuLNode prior) {
        this.prior = prior;
    }

    public DuLNode getNext() {
        return next;
    }

    public void setNext(DuLNode next) {
        this.next = next;
    }
}