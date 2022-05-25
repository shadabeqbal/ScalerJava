package com.home.trees;

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
    
    public static boolean isHeightBalanced(TreeNode root){
        if(root == null)
            return false;

        if (Math.abs(heightoftree(root.left) - heightoftree(root.right)) <= 1)
            return true;

        return false;
    }

    public static boolean isBinaryTree(TreeNode root){
        if(root == null)
            return true;

        if(root.left != null && root.left.data > root.data)
            return false;

        if(root.right != null && root.right.data < root.data)
            return false;

        isBinaryTree(root.left);
        isBinaryTree(root.right);

        return true;
    }
    public static TreeNode buildBST(Integer[] arr){
        TreeNode root = null;
        for(int i=0;i<arr.length;i++)
            root = buildBSTHelper(root,arr[i]);

        return root;

    }
    public static TreeNode buildBSTHelper(TreeNode root,int i){

        if(root == null)
            root = new TreeNode(i);
        else if(i <= root.data)
            root.left = buildBSTHelper(root.left,i);
        else
            root.right = buildBSTHelper(root.right,i);

        return root;
    }

    public static Integer ancestorList(TreeNode root,HashMap<Integer,List<Integer>> hm){
        if(root.left == null || root.right == null)
            return root.data;

        if(!hm.containsKey(root.data))
            hm.put(root.data,new ArrayList<>());

        hm.get(root.data).add(ancestorList(root.left,hm));
        hm.get(root.data).add(ancestorList(root.right,hm));

        return root.data;
    }
    public static void lca(TreeNode root,TreeNode n1,TreeNode n2){
        HashMap<Integer,List<Integer>> hm = new HashMap<>();
        int x = ancestorList(root,hm);
        System.out.println(hm);
    }
    public static void compute() {
        Integer[] arr = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Integer[] arr1 = {1,3,6,-1,-1,-1,2,5,-1,-1,4,-1,-1};
        Integer[] arr2 = {1,2,-1,-1,3,5,6,-1,-1,7,-1,-1,4,-1,-1};
        Integer[] arr3 = {10,8,-1,-1,19,17,-1,-1,21,-1,-1};
        Integer[] arr4 = {50,46,20,18,-1,-1,-1,48,-1,49,-1,-1,100,61,-1,-1,180,-1,-1};
        TreeNode root;
        TreeNode root2;
        TreeNode root3;
        TreeNode root4;
        TreeNode root5;
        root = buildTree(arr);
        i = -1;
        root2 = buildTree(arr1);
        i = -1;
        root3 = buildTree(arr2);
        i = -1;
        root4 = buildTree(arr3);
        i = -1;
        root5 = buildTree(arr4);
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
        verticalOrder(root3,0,hm);
        for(Map.Entry<Integer,List<TreeNode>> each: hm.entrySet()){
            System.out.print("[");
            for(TreeNode eachNode: each.getValue()){
                System.out.print(eachNode.data);
                if(each.getValue().size() > 1)
                    System.out.print(",");
            }

            System.out.print("],");
        }
        System.out.println();
        System.out.print("Height Balanced: ");
        System.out.print(isHeightBalanced(root3));
        System.out.println();
        System.out.println("Is Binary Tree: "+isBinaryTree(root5));

        Integer[] arr5 = {8,2,9,6,5,7};
        TreeNode root6;
        root6 = buildBST(arr5);

        System.out.println("Is Binary Tree: "+isBinaryTree(root6));
        System.out.print("Preorder: ");
        preorder(root6);
        System.out.println();
        System.out.print("Inorder: ");
        inorder(root6);
        System.out.println();
        System.out.print("Postorder: ");
        postorder(root6);

        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(7);
        lca(root6,n1,n2);


    }
}
