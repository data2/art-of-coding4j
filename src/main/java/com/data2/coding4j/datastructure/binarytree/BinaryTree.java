/**
 * FileName:   BinaryTree.java
 *
 * @Description binary tree
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.data2.coding4j.datastructure.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinaryTree {

    private TreeNode root;

    public BinaryTree() {
    }

    public BinaryTree(Object... objects) {
        for (Object obj : objects) {
            insert(obj);
        }
    }

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<Integer>();
        while (true) {
            int q = sc.nextInt(20);
            if (q == 0) {
                break;
            }
            list.add(q);
        }
        BinaryTree tree = new BinaryTree(list.toArray());
        System.out.println();
        System.out.println("binary tree is built");
        System.out.println("pre order ");
        tree.preOrder(tree.getRoot());
        System.out.println("middle order ");
        tree.middleOrder(tree.getRoot());
        System.out.println("last order ");
        tree.lastOrder(tree.getRoot());
        System.out.println("深度:" + tree.treeDepth(tree.getRoot()));

    }

    /**
     * insert int binary tree
     */
    @SuppressWarnings("unchecked")
    private boolean insert(Object obj) {
        if (root == null) {
            root = new TreeNode(obj);
        } else {
            TreeNode parent = null;
            TreeNode current = root;
            while (current != null) {
                if (((Comparable<Object>) obj).compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (((Comparable<Object>) obj).compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else {
                    return false;
                }
            }
            if (((Comparable<Object>) obj).compareTo(parent.element) > 0) {
                parent.right = new TreeNode(obj);
            } else {
                parent.left = new TreeNode(obj);
            }
        }
        return true;
    }

    public TreeNode getRoot() {
        return root;
    }

    /**
     * 前序遍历
     */
    private void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.element);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历
     */
    private void middleOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        middleOrder(node.left);
        System.out.println(node.element);
        middleOrder(node.right);
    }

    /**
     * 后序遍历
     */
    private void lastOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        lastOrder(node.left);
        lastOrder(node.right);
        System.out.println(node.element);
    }

    /**
     * 深度
     */
    private int treeDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = treeDepth(node.left);
        int right = treeDepth(node.right);
        return left > right ? left + 1 : right + 1;
    }
}
