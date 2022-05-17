package com.home.trees;

import apple.laf.JRSUIUtils;
import sun.lwawt.macosx.CSystemTray;

import java.util.*;

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
        newNode.right = buildTree(arr);

        return newNode;
    }

    public static void preorder(TreeNode root){
        if(root == null)
            return;

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void preorder_iterative(TreeNode root){
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        TreeNode ptr = root;
        while(ptr != null || !st.empty()){
            if(ptr != null){
                System.out.println(ptr.data);
                st.push(ptr.left);
                ptr = ptr.left;
            }else{
                ptr = st.peek();
                st.pop();
            }
        }

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

    public static void levelorder(TreeNode root,Queue<TreeNode> q){

        if(root == null)
            return;

        q.add(root);
        if(q.isEmpty())
            return;

        while(!q.isEmpty()){
            if(q.peek().left != null)
                q.add(q.peek().left);
            if(q.peek().right != null)
                q.add(q.peek().right);

            System.out.print(q.poll().data+" ");
        }

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
            return -1;

        return Math.max(heightoftree(root.left),heightoftree(root.right)) + 1;
    }

    public static void verticalOrder(TreeNode n1, Integer currLevel,Map<Integer,List<TreeNode>> hm){
        if(n1 == null)
            return;

        List<TreeNode> lst;

        if(!hm.containsKey(currLevel)) {
            lst = new ArrayList<>();
            lst.add(n1);
            hm.put(currLevel, lst);
        }else{
            lst = hm.get(currLevel);
            lst.add(n1);
        }

        verticalOrder(n1.left,currLevel-1,hm);
        verticalOrder(n1.right,currLevel+1,hm);

    }
    public static boolean isMirror(TreeNode n1, TreeNode n2){
        if(n1 == null && n2 == null)
            return true;

        if(n1 == null && n2 != null)
            return false;
        if(n1 != null && n2 == null)
            return false;

        if(n1.data != n2.data)
            return false;

        isMirror(n1.left,n2.right);
        isMirror(n1.right,n2.left);

        return true;
    }

    public static void compute() {
        Integer[] arr = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Integer[] arr1 = {1,3,6,-1,-1,-1,2,5,-1,-1,4,-1,-1};
        TreeNode root = null;
        TreeNode root2 = null;
        root = buildTree(arr);
        i = -1;
        root2 = buildTree(arr1);
        System.out.println(root.data);
        System.out.print("Preorder: ");
        preorder(root);
        System.out.println();
        System.out.print("Preorder_Iterative: ");
        preorder_iterative(root);
        System.out.println();
        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();
        System.out.print("Postorder: ");
        postorder(root);
        System.out.println();
        Queue<TreeNode> q = new LinkedList<>();
        System.out.print("Level Order: ");
        levelorder(root,q);
        System.out.println();
        System.out.print("Nodes Count: ");
        System.out.println(countnodes(root));
        System.out.print("Nodes Sum: ");
        System.out.println(sumofnodes(root));
        System.out.print("Height: ");
        System.out.println(heightoftree(root));
        System.out.print("isMirror: ");
        System.out.println(isMirror(root,root2));
        System.out.print("VerticalOrder: ");
        HashMap<Integer,List<TreeNode>> hm = new HashMap<>();
        verticalOrder(root,0,hm);
        for(Map.Entry<Integer,List<TreeNode>> each: hm.entrySet()){
            System.out.print("[");
            for(TreeNode eachNode: each.getValue()){
                System.out.print(eachNode.data);
                if(each.getValue().size() > 1)
                    System.out.print(",");
            }

            System.out.print("],");
        }
    }
}
