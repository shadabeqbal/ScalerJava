package com.home.trees;

import apple.laf.JRSUIUtils;
import sun.lwawt.macosx.CSystemTray;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class tree1 {
    static int i = -1;
    public static TreeNode buildTree(Integer[] arr){
        i++;
        if(arr[i] == -1)
            return null;

        TreeNode newNode = new TreeNode(arr[i]);
        newNode.left = buildTree(arr);
        newNode. right = buildTree(arr);

        return newNode;
    }
    public static void preorder(TreeNode root){
        if(root == null)
            return;

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(TreeNode root){
        if(root == null)
            return;

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void postorder(TreeNode root){
        if(root == null)
            return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }

    public static void levelorder(TreeNode root,Queue<Integer> q){

        if(root == null)
            return;

        q.add(root.data);
        if(q.isEmpty())
            return;

        System.out.print(q.poll()+" ");
        levelorder(root.left,q);
        levelorder(root.right,q);


    }

    public static int countnodes(TreeNode root){
        if(root == null)
            return 0;

        return countnodes(root.left) + countnodes(root.right) + 1;

    }

    public static int sumofnodes(TreeNode root){
        if(root == null)
            return 0;

        return sumofnodes(root.left) + sumofnodes(root.right) + root.data;
    }

    public static int heightoftree(TreeNode root){
        if(root == null)
            return 0;

        return Math.max(heightoftree(root.left),heightoftree(root.right)) + 1;
    }
    public static void compute() {
        Integer[] arr = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        TreeNode root = null;
        root = buildTree(arr);
        System.out.println(root.data);
        System.out.print("Preorder: ");
        preorder(root);
        System.out.println();
        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();
        System.out.print("Postorder: ");
        postorder(root);
        System.out.println();
        Queue<Integer> q = new LinkedList<>();
        System.out.print("Level Order: ");
        levelorder(root,q);
        System.out.println();
        System.out.print("Nodes Count: ");
        System.out.println(countnodes(root));
        System.out.print("Nodes Sum: ");
        System.out.println(sumofnodes(root));
        System.out.print("Height: ");
        System.out.println(heightoftree(root));

    }
}
