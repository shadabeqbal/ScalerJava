package com.home.stacks;

import java.util.Stack;

public class postfixEval {

    public static void compute(){
        String str = "423+5*6/3+*";
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<str.length();i++){
            if(Character.isDigit(str.charAt(i)))
                st.push(Character.getNumericValue(str.charAt(i)));
            else{
                int x = st.pop();
                int y = st.pop();
                int ans = -1;
                switch (str.charAt(i)){
                    case '*':
                        ans = x*y;
                        st.push(ans);
                        break;
                    case '+':
                        ans = x+y;
                        st.push(ans);
                        break;
                    case '-':
                        ans = x-y;
                        st.push(ans);
                        break;
                    case '/':
                        ans = x/y;
                        st.push(ans);
                        break;
                    default:
                        System.out.println("Operator Undefined");
                        break;
                }
            }
        }

        System.out.println(st.peek());
    }
}
