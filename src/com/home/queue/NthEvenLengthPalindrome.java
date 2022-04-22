package com.home.queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class NthEvenLengthPalindrome {
    public static void compute(){
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        queue.add("2");
        int n = 10;
        while(queue.size() != n+2){
            String s = queue.poll();
            StringBuilder str = new StringBuilder(s);
            System.out.println(s+str.reverse());
            String x = s+"1";
            String y = s+"2";
            queue.add(x);
            queue.add(y);
            n--;
        }
    }
}
