package com.home.linkedlist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Node{
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
class LinkedList{
    public static Node buildLL(Integer[] arr){
        Node root = null;
        int i = 0;
        root = new Node(arr[i]);
        Node start = root;
        while(i < arr.length-1){
            i++;
            Node temp = new Node(arr[i]);
            root.next = temp;
            root = root.next;
        }

        return start;
    }
    public static Node buildLL() {
        Node p1 = new Node(1);
        Node root = p1;
        int i = 2;
        while(i != 11) {
            Node p2 = new Node(i);
            p1.next = p2;
            p1=p2;
            i++;
        }

        return root;
    }

    public static Node addTwoNumbers(Node l1, Node l2) {
        Stack<Double> st = new Stack<>();
        int i = 0;
        long sum1=0,sum2=0;
        while(l1 != null){
            st.push(l1.data * Math.pow(10,i));
            i++;
            l1 = l1.next;
        }

        while(!st.empty()){
            sum1+=st.pop();
        }

        i = 0;

        while(l2 != null){
            st.push(l2.data * Math.pow(10,i));
            i++;
            l2 = l2.next;
        }

        while(!st.empty()){
            sum2+=st.pop();
        }

        long ans = sum1+sum2;
        long temp = 0;
        long x = ans%10;
        Node root = new Node((int)x);
        ans=ans/10;
        Node start = root;
        while(ans != 0){
            temp = ans%10;
            Node tot = new Node((int)temp);
            root.next = tot;
            root = root.next;
            ans=ans/10;
        }

        return start;
    }
}
public class ReverseLL {

    public static void compute(){
        Integer arr[] = {9};
        Integer arr1[] = {1,9,9,9,9,9,9,9,9,9};
        Node l1 = LinkedList.buildLL(arr);
        Node l2 = LinkedList.buildLL(arr1);
        Node l3 = LinkedList.addTwoNumbers(l1,l2);

        while(l3 != null){
            System.out.println(l3.data);
            l3 = l3.next;
        }
    }

    public static void reverse(){
        Node root = LinkedList.buildLL();
        Node current = root;
        Node next;
        Node prev = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        root = prev;

        while(root.next != null){
            System.out.println(root.data);
            root = root.next;
        }
    }
}
