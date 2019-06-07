package com.sg.common.domain.Node;

import java.util.List;

/**
 * @Description 节点
 * @Author ShGuan
 * @Date 2019/6/4 23:42
 **/
public class TreeNode {
    /**
     * 节点序号
     */
    private int id;

    /**
     * 根节点序号
     */
    private int rootId;

    /**
     * 父节点序号
     */
    private int parentId;

    /**
     * 数据域
     */

    private String data;

    /**
     * 左孩子
     */
    private List<TreeNode> leftChildren;

    /**
     * 右孩子
     */
    private List<TreeNode> rightChildren;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRootId() {
        return rootId;
    }

    public void setRootId(int rootId) {
        this.rootId = rootId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<TreeNode> getLeftChildren() {
        return leftChildren;
    }

    public void setLeftChildren(List<TreeNode> leftChildren) {
        this.leftChildren = leftChildren;
    }

    public List<TreeNode> getRightChildren() {
        return rightChildren;
    }

    public void setRightChildren(List<TreeNode> rightChildren) {
        this.rightChildren = rightChildren;
    }
}