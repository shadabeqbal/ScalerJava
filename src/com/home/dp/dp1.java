package com.home.dp;

import java.util.Arrays;

public class dp1 {
    public static void compute(){
        int x = 500;
        Integer[] arr = new Integer[x+1];
        Arrays.fill(arr,-1);
        //Integer n = fibo(x,arr);
        //Integer n = stepup(3 ,arr);
        Integer n = partyWays(3,arr);
        System.out.println(n);

        int[] arr1 = {1,2,1,5};
        int y = LIS(arr1,0,arr1.length,-1);
        System.out.println(y);
        char[] arr2 = {'a','b','b','c','d','g','f'};
        char[] arr3 = {'b','b','a','d','c','g','f'};
        int z = LCS(arr2,arr3,0,0);
        System.out.println(z);
    }

    public static int LCS(char[] arr1,char[] arr2,int i,int j){
        if(i > arr1.length-1 || j > arr2.length-1)
            return 0;


        if(arr1[i] == arr2[j])
            return 1 + LCS(arr1,arr2,i+1,j+1);
        else{
            return Math.max(LCS(arr1,arr2,i+1,j),LCS(arr1,arr2,i,j+1));
        }
    }
    public static int LIS(int[] arr,int i,int j,int prev){
        if(i == j)
            return 0;

        int exclude = LIS(arr,i+1,j,prev);

        int include = 0;
        if(arr[i] > prev)
            include = 1 + LIS(arr,i+1,j,arr[i]);

        return Math.max(include,exclude);
    }

    public static int partyWays(int n,Integer[] arr){
        if(n <= 0)
            return 1;

        if(arr[n] != -1)
            return arr[n];

        arr[n] = partyWays(n-1,arr) + (partyWays(n-2,arr)*(n-1));
        return arr[n];
    }
    public static int stepup(int n,Integer[] arr){
        if(n <= 1)
            return 1;

        if(arr[n] != -1)
            return arr[n];

        arr[n] = stepup(n-1,arr) + stepup(n-2,arr);
        return arr[n];
    }
    public static int fibo(int n,Integer[] arr){
        if(n < 2)
            return n;

        if(arr[n] != -1)
            return arr[n];

        arr[n] = fibo(n-1,arr)+fibo(n-2,arr);
        return arr[n];
    }
}
