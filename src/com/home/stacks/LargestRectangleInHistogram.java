package com.home.stacks;

import java.util.ArrayList;
import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void compute(){
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(1);
        input.add(3);
        input.add(1);
        input.add(1);
        input.add(2);


        Stack<Integer> stack = new Stack<>();
        Stack<Integer> tempStack = new Stack<>();

        Integer tempArea = -1;
        Integer finalArea = -1;

        for(Integer i: input){
            if(stack.empty()){

                finalArea = i;
                stack.push(i);
            }else{
                Integer cnt = 1;
                while(!stack.empty() && stack.peek() >= i){
                    tempStack.push(stack.pop());
                    cnt++;
                }

                tempArea = i * cnt;
                finalArea = Math.max(finalArea,tempArea);

                while(!tempStack.empty())
                    stack.push(tempStack.pop());

                stack.push(i);
            }
        }

        System.out.println(finalArea);

    }
}
