package com.home;

import com.home.stacks.SortedStack;
import com.home.stacks.SpecialStack;
import sun.lwawt.macosx.CSystemTray;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
//        SpecialStack ss = new SpecialStack();
//        ss.push(5);
//        ss.push(3);
//        ss.push(1);
//        ss.push(4);
//        ss.push(2);
//        ss.push(9);
//        ss.push(0);
//        ss.push(23);
//        ss.pop();
//
//        System.out.println(ss.isEmpty());
//        System.out.println(ss.getMin());

        SortedStack ss = new SortedStack();
        ss.push(5);
        ss.push(6);
        ss.push(1);
        ss.push(7);
        ss.push(4);
        ss.pop();
        ss.push(2);
        ss.push(9);
        ss.push(3);
        ss.push(10);
        ss.push(27);
        ss.pop();
        ss.push(12);
        ss.push(11);

        System.out.println(ss.showStack());
    }
}