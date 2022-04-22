package com.home.stacks;

import java.util.Stack;

public class DoubleCharTrouble {
    public String service(String str){
        Stack<Character> st = new Stack<>();
        for(int i=0;i<str.length();i++){
            if(!st.empty() && st.peek() == str.charAt(i)){
                st.pop();
            }else {
                st.push(str.charAt(i));
            }
        }

        return st.toString();
    }
}
