package com.home.extras;

import java.util.HashSet;
import java.util.Set;

public class problemSet1 {
    public static boolean compute(Integer[] arr){
        Set<Integer> st = new HashSet<>();

        for(int i: arr)
            st.add(i);

        for(int i: arr)
        {
            if(i%2 == 0 && st.contains(i*2))
                return true;
        }

        return false;
    }
}
