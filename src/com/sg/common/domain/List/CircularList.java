package com.sg.common.domain.List;

import com.sg.common.domain.Node.LinkNode;

/**
 * @Description 循环链表
 * @Author ShGuan
 * @Date 2019/6/7 16:51
 **/
public class CircularList extends LinkList {

    /**
     * 头结点
     */
    private LinkNode head;

    /**
     * 尾结点
     */
    private LinkNode tail;

    public CircularList() {
        head = new LinkNode();
        tail = new LinkNode();
        tail.setNext(head);
    }

    public CircularList(int n, boolean order) throws Exception {
        super(n, order);
        if (order) {
            createFromTail(n);
        } else {
            createFromHead(n);
        }
        tail = getTail();
        tail.setNext(head);
    }

    public LinkNode getTail() {
        if (head.getNext() != null) {
            tail = head.getNext();
            int n = 0;
            while (tail.getNext() != null && n < length()) {
                tail = tail.getNext();
                ++n;
            }
            return tail;
        }
        return null;
    }
}