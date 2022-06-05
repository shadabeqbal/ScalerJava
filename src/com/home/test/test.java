package com.home.test;

import java.util.HashMap;
import java.util.Map;

public class test {
    public static void compute(){
        Integer arr[] = {1,1,2,2,3,3,3,4,5,5,6};
        int k = 4;
        int first = 0, second = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        int distinct = 0;
        while(second < arr.length && first < second)
        {
            if(distinct >= k)
                break;

            if(!hm.containsKey(arr[second])) {
                hm.put(arr[second], 1);
                distinct++;
            }else{
                hm.put(arr[second],hm.get(arr[second])+1);
            }

            second++;

            if(second-first+1 == k){
                if(hm.containsKey(arr[first]))
                    hm.put(arr[first],hm.get(arr[first])-1);
                else
                    hm.remove(arr[first]);

                first++;
            }
        }

        for(Map.Entry<Integer,Integer> each: hm.entrySet()){
            System.out.println(each.getKey() + "" + each.getValue());
        }

    }
}
