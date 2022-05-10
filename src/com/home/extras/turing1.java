package com.home.extras;

import java.util.Stack;

public class turing1 {
    public static int calPoints(String[] ops){
        int result = 0;
        Stack<String> st = new Stack<>();
        for(String i : ops){
            if(i.equals("+")){
                String first = st.pop();
                String second = st.pop();

                int x = Integer.parseInt(first);
                int y = Integer.parseInt(second);
                int res = x+y;
                st.push(first);
                st.push(second);
                st.push(Integer.toString(res));
            }else if(i.equals("C")){
                st.pop();
            }else if (i.equals("D")){
                String first = st.pop();
                int x = Integer.parseInt(first) * 2;
                st.push(first);
                st.push(Integer.toString(x));
            }else{
                st.push(i);
            }
        }

        while(!st.empty()){
            int temp_res = Integer.parseInt(st.pop());
            result += temp_res;
        }
        return result;
    }
}
