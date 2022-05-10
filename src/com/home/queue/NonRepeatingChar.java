package com.home.queue;

import sun.awt.image.ImageWatched;

import java.lang.reflect.Array;
import java.util.*;

public class NonRepeatingChar {

    public static void compute(Character[] arr){
        Map<Character,Integer> mp = new HashMap<>();
        Queue<Character> q = new LinkedList<>();
        Character[] res = new Character[arr.length];
        int i=0;
        for(Character each:arr){
            if(!mp.containsKey(each)) {
                mp.put(each, 1);
                q.add(each);
            }else {
                mp.put(each, mp.get(each) + 1);
            }
            if(!q.isEmpty() && mp.get(q.peek()) == 1)
                res[i++] = q.peek();
            else{
                while(!q.isEmpty() && mp.get(q.peek()) != 1)
                    q.remove();

                if(!q.isEmpty())
                    res[i++] = q.peek();
                else
                    res[i++] = '#';
            }
        }

        for(Character x: res)
            System.out.print(x+" ");
    }
}
