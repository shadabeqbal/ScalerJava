package com.home.stacks;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.Stack;

public class MaxAndMin {
    public static void compute(){
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(3);
        input.add(0);
        input.add(4);
        input.add(6);
        input.add(8);

        System.out.println(nearestSmallerLeft(input));
    }

    public static ArrayList<Integer> nearestSmallerLeft(ArrayList<Integer> arr){

        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        Stack<Integer> tempStack = new Stack<>();
        for(int i=0;i<arr.size();i++){
            if(st.empty()){
                ans.add(-1);
                st.push(arr.get(i));
            }else{
                while(!st.empty() && st.peek() > arr.get(i))
                    tempStack.push(st.pop());

                if(!st.empty())
                    ans.add(st.peek());
                else
                    ans.add(-1);

                while(!tempStack.empty())
                    st.push(tempStack.pop());

                st.push(arr.get(i));
            }
        }

        return ans;
    }
}
