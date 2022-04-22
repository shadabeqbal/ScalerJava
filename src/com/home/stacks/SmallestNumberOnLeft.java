package com.home.stacks;

import java.util.ArrayList;
import java.util.Stack;

public class SmallestNumberOnLeft {
    public static void smallestNum(){

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(3);
        arr.add(5);
        arr.add(6);
        arr.add(2);
        arr.add(8);
        arr.add(7);
        arr.add(0);
        arr.add(9);

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

        System.out.println(arr);
        System.out.println(ans);
    }
}
