package com.home.extras;

import java.util.Stack;

public class turing2 {
    public static boolean isValid(String s){
        boolean result = false;
        Stack<Character> st = new Stack<>();
        int i = 0;
        for(i=0;i<s.length();i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                st.push(s.charAt(i));
            else{
                if(st.empty() || s.charAt(i) == ')' && st.peek() != '(')
                    break;
                if(st.empty() || s.charAt(i) == '}' && st.peek() != '{')
                    break;
                if(st.empty() || s.charAt(i) == ']' && st.peek() != '[')
                    break;

                st.pop();
            }
        }

        if(st.empty() && i == s.length())
            result = true;

        return result;
    }
}
