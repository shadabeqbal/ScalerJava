package com.home.extras;

import java.util.ArrayList;
import java.util.Arrays;

public class PairLargestSumLessThanK {

    public static int compute(int[] arr,int K){
        int result = Integer.MIN_VALUE;
        Arrays.sort(arr);
        int l = 0;
        int r = arr.length - 1;
        while (l < r){
            if(arr[l] + arr[r] < K){
                result = Math.max(result,arr[l]+arr[r]);
                l++;
            }else{
                r--;
            }
        }
        return result;
    }
}
