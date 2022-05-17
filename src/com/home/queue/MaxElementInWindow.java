package com.home.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MaxElementInWindow {
    public static int calculateMax(Integer[] arr,int low, int high){
        int res = -1;
        int res_idx = 0;
        for(int i = low;i<high;i++){
            if(arr[i] > res)
            {
                res = arr[i];
                res_idx = i;
            }
        }

        return res_idx;
    }
    public static ArrayList<Integer> compute(Integer[] arr,int k){
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int low = 0;
        int high = k-1;
        int max = Integer.MIN_VALUE;
        int max_idx = 0;
        for(int i=low;i<=high;i++){
            if(arr[i] > max){
                max = arr[i];
                max_idx = i;
            }
        }

        result.add(max);
        q.add(max_idx);

        while(high < arr.length && low < arr.length - k){
            low++;
            high++;
            if(q.peek() < low){
                q.remove();
                q.add(calculateMax(arr,low,high));
            }

            if(arr[q.peek()] < arr[high]){
                q.remove();
                q.add(high);
                result.add(arr[high]);
            }else{
                result.add(arr[q.peek()]);
            }
        }


        return result;
    }
}
