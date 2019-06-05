package com.sg.common;

import java.util.List;

/**
 * @Description 节点
 * @Author ShGuan
 * @Date 2019/6/4 23:42
 **/
public class Node {
    /**
     * 节点序号
     */
    private String id;

    /**
     * 根节点序号
     */
    private String rootId;

    /**
     * 父节点序号
     */
    private String parentId;

    /**
     * 左孩子
     */
    private List<Node> leftChildren;

    /**
     * 右孩子
     */
    private List<Node> rightChildren;
}