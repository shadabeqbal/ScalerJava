package com.home.linkedlist;

import java.rmi.UnexpectedException;

class Node{
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
class LinkedList{
    public static Node buildLL() {
        Node p1 = new Node(1);
        Node root = p1;
        int i = 2;
        while(i != 10) {
            Node p2 = new Node(i);
            p1.next = p2;
            p1=p2;
            i++;
        }

        return root;
    }
}
public class ReverseLL {

    public static void reverse(){
        Node root = LinkedList.buildLL();
        Node p = root;
        Node q = root.next;
        Node r = null;

        while(p.next !=null){
            p.next = r;
            r = p;
            p = q;
            q = p.next;
        }

        p.next = r;

        while(p.next != null){
            System.out.println(p.data);
            p = p.next;
        }
    }
}
