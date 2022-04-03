package com.home.stacks;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Stack;

public class SpecialStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();


    public void push(Integer n){
        if(stack.empty()) {
            stack.push(n);
            minStack.push(n);
        }else{
            if(n > minStack.peek()){
                stack.push(n);
                minStack.push(minStack.peek());
            }else{
                stack.push(n);
                minStack.push(n);
            }
        }
     }

    public int pop(){
        int element = -1;
        if(stack.isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }else{
            element = stack.peek();
            stack.pop();
            minStack.pop();
        }

        return element;
    }

    public boolean isEmpty(){
        if(stack.isEmpty())
            return true;
        else
            return false;
    }

    public int getMin(){
        if(!minStack.isEmpty())
            return minStack.peek();
        else
            return -1;
    }
}
