package com.sg.common.domain.List;

import com.sg.common.domain.IList;
import com.sg.common.domain.Node.DuLNode;
import com.sg.common.domain.Node.LinkNode;

import java.util.Scanner;


/**
 * @Description 双向链表
 * @Author ShGuan
 * @Date 2019/6/7 17:18
 **/
public class DuLinkList implements IList {

    private DuLNode head;

    private DuLNode tail;

    public DuLinkList() {
        head = new DuLNode();
        tail = new DuLNode();
    }

    public DuLinkList(int n, boolean order) throws Exception {
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
        tail.setData(null);
        tail.setNext(null);
    }

    @Override
    public boolean isEmpty() {
        return head.getNext() == null;
    }

    @Override
    public int length() {
        DuLNode p = head.getNext();
        int length = 0;
        while (p != null) {
            p = p.getNext();
            ++length;
        }
        return length;
    }

    @Override
    public Object get(int n) throws Exception {

        // 元素在前一半采用从前向后遍历， 在后一半从后向前遍历
        if (n > length() / 2) {
            DuLNode p = tail.getPrior();
            int i = length();
            while (p != null && i > n) {
                p = p.getPrior();
                --i;
            }
            if (i < n || p == null) {
                throw new Exception("第" + i + "个元素不存在");
            }
            return p.getData();
        } else {
            DuLNode p = head.getNext();
            int j = 0;
            while (p != null && j < n) {
                p = p.getNext();
                ++j;
            }
            if (j > n || p == null){
                throw new Exception("第" + n + "个元素不存在");
            }
            return p.getData();
        }
    }

    @Override
    public void insert(int n, Object object) throws Exception {
        DuLNode p = new DuLNode();
        if (n > length() / 2) {
            // 插入结点的后继结点
            int i = length() + 1;
            while (p != null && i > n + 1) {
                p = p.getPrior();
                --i;
            }
            if (i < n + 1 || p == null) {
                throw new Exception("插入位置不合法");
            }
            DuLNode s = new DuLNode(object);
            p.getPrior().setNext(s);
            s.setPrior(p.getPrior());
            s.setNext(p);
            p.setPrior(s);
        } else {

            // 插入结点的前驱结点
            int j = -1;
            while (p != null && j < n - 1) {
                p = p.getNext();
                ++j;
            }
            if (j > n - 1 || p == null) {
                throw new Exception("插入位置不合法");
            }
            DuLNode s = new DuLNode(object);
            p.getNext().setPrior(s);
            s.setNext(p.getNext());
            s.setPrior(p);
            p.setNext(s);
        }

    }

    @Override
    public void remove(int n) throws Exception {
        if (n > length() / 2) {
            DuLNode p = tail;
            int i = length() + 1;
            while (p.getPrior() != null && i > n + 1) {
                p = p.getPrior();
                --i;
            }
            if (i < n + 1 || p.getPrior() == null) {
                throw new Exception("删除位置不合法");
            }
            p.setPrior(p.getPrior().getPrior());
            p.getPrior().setNext(p);
        } else {
            DuLNode p = head;
            int j = -1;
            while (p.getNext() != null && j < n - 1) {
                p = p.getNext();
                ++j;
            }
            if (j > n - 1 || p.getNext() == null) {
                throw new Exception("删除位置不合法");
            }
            p.setNext(p.getNext().getNext());
            p.getNext().setPrior(p);
        }


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
        DuLNode node = head.getNext();
        while (node != null) {
            System.out.print(node.getData() + " ");
            node = node.getNext();
        }
        // 换行
        System.out.println();
    }
}