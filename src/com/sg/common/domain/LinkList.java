package com.sg.common.domain;

import com.sg.common.IList;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Scanner;

/**
 * @Description 单链表
 * @Author ShGuan
 * @Date 2019/6/7 15:43
 **/
public class LinkList implements IList{

    /**
     * 头指针
     */
    private LinkNode head;

    public LinkList() {
        head = new LinkNode();
    }

    public LinkList(int n, boolean order) throws Exception {
        this();
        if (order) {
            createFromTail(n);
        } else {
            createFromHead(n);
        }
    }

    public void createFromHead(int n) throws Exception {
        Scanner scanner = new Scanner(System.in);
        for (int j = 0; j < n; j++) {
            insert(0, scanner.next());
        }
    }

    public void createFromTail(int n) throws Exception {
        Scanner scanner = new Scanner(System.in);
        for (int j = 0; j < n; j++) {
            insert(length(), scanner.next());
        }
    }

    @Override
    public void clear() {
        head.setData(null);
        head.setNext(null);
    }

    @Override
    public boolean isEmpty() {
        return head.getNext() == null;
    }

    @Override
    public int length() {
        LinkNode p = head.getNext();
        int length = 0;
        while (p != null) {
            p = p.getNext();
            ++length;
        }
        return length;
    }

    @Override
    public Object get(int i) throws Exception {
        LinkNode p = new LinkNode();
        int j = 0;
        while (p != null && j < i) {
            p = p.getNext();
            ++j;
        }
        if (j > i || p == null){
            throw new Exception("第" + i + "个元素不存在");
        }
        return p.getData();
    }

    @Override
    public void insert(int i, Object object) throws Exception {
        LinkNode p = new LinkNode();
        // 插入节点的前去节点
        int j = -1;
        while (p != null && j < i - 1) {
            p = p.getNext();
            ++j;
        }
        if (j > i - 1 || p == null) {
            throw new Exception("插入位置不合法");
        }
        LinkNode s = new LinkNode(object);
        s.setNext(p.getNext());
        p.setNext(s);
    }

    @Override
    public void remove(int i) throws Exception {
        LinkNode p = head;
        int j = -1;
        while (p.getNext() != null && j < i - 1) {
            p = p.getNext();
            ++j;
        }
        if (j > i - 1 || p.getNext() == null) {
            throw new Exception("删除位置不合法");
        }
        p.setNext(p.getNext().getNext());
    }

    @Override
    public int indexOf(Object object) {
        LinkNode p = new LinkNode();
        int j = 0;
        while (p != null && !p.getData().equals(object)) {
            p = p.getNext();
            ++j;
        }
        if (p != null) {
            return j;
        }else {
           return -1;
        }
    }

    @Override
    public void display() {
        LinkNode node = head.getNext();
        while (node != null) {
            System.out.print(node.getData() + " ");
            node = node.getNext();
        }
        // 换行
        System.out.println();
    }
}