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
        while(i != 11) {
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
