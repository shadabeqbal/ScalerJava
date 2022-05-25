package com.home.tries;

import java.util.HashMap;
import java.util.Map;

class TrieNode{
    char c;
    Map<Character,TrieNode> mp;

    TrieNode(char c){
        this.c = c;
        this.mp = new HashMap<>();
    }
}

public class tries {

    public static void buildTrie(TrieNode root,String names,int index){

        if(index == names.length())
            return;
        if(root.mp.get(names.charAt(index)) == null) {
            TrieNode newNode = new TrieNode(names.charAt(index));
            root.mp.put(names.charAt(index), newNode);
            root = newNode;
        }else{
            root = root.mp.get(names.charAt(index));
        }

        buildTrie(root,names,index+1);
    }
    public static void compute(){
        TrieNode node = new TrieNode('#');
        buildTrie(node,"shadab",0);
        buildTrie(node,"sharab",0);

        System.out.println(node.mp);
    }
}
