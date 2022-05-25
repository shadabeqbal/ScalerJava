package com.home;

import com.home.trees.tree1;
import com.home.tries.tries;

public class Main {

    public static void main(String[] args) {

        //postfixEval.compute();
        //SmallestNumberOnLeft.smallestNum();
        //LargestRectangleInHistogram.compute();
        //MaxAndMin.compute();
        //NthEvenLengthPalindrome.compute();
        //ReverseLL.reverse();
        //problem1.compute();
//        String[] ops = {"5","2","7","C","D","+"};
//        turing1 obj = new turing1();
//        turing2 obj2 = new turing2();
//        int res = obj.calPoints(ops);
//        boolean res1 = obj2.isValid("[{()}]");
//        System.out.println(res);
//        System.out.println(res1);
//        Character[] ch = {'a','b','c','b','a','c','d'};
//        Character[] ch1 = {'a','b','a','a','b','b','c'};
//        NonRepeatingChar.compute(ch1);
//        Integer[] arr = {10,9,8,7,6,5,4,3,2,1};
//        Integer[] arr1 = {1,3,2,5,7,6};
//        ArrayList<Integer> result = MaxElementInWindow.compute(arr1,3);
//        for(Integer x: result)
//            System.out.print(x+" ");

//        String result = null;
//        String str = "ab-cd";
//        char[] str1 = str.toCharArray();
//
//        int r = str1.length - 1;
//        int l = 0;
//        while(l < r){
//            if(!Character.isAlphabetic(str1[l]))
//                l++;
//            else if(!Character.isAlphabetic(str1[r]))
//                r--;
//            else{
//                char temp = str1[l];
//                str1[l] = str1[r];
//                str1[r] = temp;
//                l++;
//                r--;
//            }
//        }
//
//        result = new String(str1);
//        System.out.println(result);
//        int[] arr = {5,20,110,100,10};
//        int k = 85;
//        int result = PairLargestSumLessThanK.compute(arr,k);
//        System.out.println(result);

        tries.compute();
    }
}
