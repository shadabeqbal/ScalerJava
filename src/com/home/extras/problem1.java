package com.home.extras;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class problem1 {
    public static void compute(){
        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(7);
        arr.add(3);
        arr.add(9);
        arr.add(11);

        Queue<Integer> q = new PriorityQueue<>();

        for(int i : arr)
            q.add(i);

        int total_sum = 0;
        while(q.size() > 1){
            int x = q.remove();
            int y = q.remove();
            int sum = x+y;
            total_sum += sum;
            q.add(sum);
        }

        System.out.println(total_sum);
    }


}
