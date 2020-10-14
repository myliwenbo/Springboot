package vip.xjdai.tree;

import lombok.Data;

@Data
//定义树节点
public class Node {

    private int key;        //节点索引
    private int value;      //节点值
    private int count;      //节点个数
    private Node left;      //左孩子
    private Node right;     //右孩子

    //
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.left = this.right = null;
    }

    //返回树的节点个数
    public int size() {
        return count;
    }

    //判断树空
    public boolean isEmpty() {
        return count == 0;
    }

    //向根节点为root的树中插入节点
    public Node insert(Node root, int key, int value) {
        if (root == null) {
            count++;
            return new Node(key, value);
        }
        if (key == root.key)
            root.value = value;
        if (key < root.key)
            root.left = insert(root.left, key, value);
        if (key > root.key)
            root.right = insert(root.right, key, value);
        //返回root
        return root;
    }

    //二叉搜索树查找,按键查找
    public Node search(Node root, int key) {
        if (root == null)
            return null;
        if (root.key == key)
            return root;
        else if (key < root.key)
            return search(root.left, key);
        else
            return search(root.right, key);
    }
}