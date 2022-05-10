package com.home;

import com.home.extras.turing1;
import com.home.extras.turing2;
import com.home.queue.NonRepeatingChar;
import com.home.trees.*;

import java.util.*;

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
        Character[] ch = {'a','b','c','b','a','c','d'};
        Character[] ch1 = {'a','b','a','a','b','b','c'};
        NonRepeatingChar.compute(ch1);

    }
}
