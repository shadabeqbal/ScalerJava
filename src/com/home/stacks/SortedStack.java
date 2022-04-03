package com.home.stacks;

import java.util.Stack;

public class SortedStack {

    Stack<Integer> st = new Stack<>();
    Stack<Integer> auxStack = new Stack<>();
    public void push(Integer n){
        if(st.empty()){
            st.push(n);
        }else{
            if(st.peek() < n){
                while(!st.empty() && n > st.peek())
                    auxStack.push(st.pop());

                st.push(n);

                while(!auxStack.empty())
                    st.push(auxStack.pop());
            }else{
                st.push(n);
            }
        }
    }

    public int pop(){
        int element;
        if(!st.empty()){
            element = st.pop();
        }else{
            element = -1;
        }

        return element;
    }

    public Stack<Integer> showStack(){
        return st;
    }
}
