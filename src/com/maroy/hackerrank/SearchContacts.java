package com.maroy.hackerrank;

import java.util.HashMap;
import java.util.Scanner;

class TrieNode {
	
	int size;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    boolean isLeaf;
 
}

public class SearchContacts {

    static int result = 0;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        TrieNode node = new TrieNode();
        
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            
            if(op.equalsIgnoreCase("add"))
                insert(contact, node);
            
            if(op.equalsIgnoreCase("find")){
                System.out.println(findPartial(contact, node));
                result = 0;
            }
        }
    }
    
    private static void insert(String key, TrieNode node) {
		
		HashMap<Character, TrieNode> children = node.children;
		int len = key.length();
		
		for(char c : key.toCharArray()) {
			
			TrieNode ct;
			if(children.containsKey(c)) {
				
				ct = children.get(c);	
			}
			else {
				ct = new TrieNode();
				children.put(c, ct);
			}
			ct.size++;
			children = ct.children;
			len--;
			
			if(len == 0)
				ct.isLeaf = true;
		}
	}
    
    private static int findPartial(String key, TrieNode node) {
		
		HashMap<Character, TrieNode> children = node.children;
		int keylen = key.length();
        
		for(char c : key.toCharArray()) {
			
			if(children.containsKey(c)) {
				
				TrieNode ct = children.get(c);
				children = ct.children;	
				keylen--;
				if(keylen == 0)
					return ct.size;
			}
			else {
				return 0;
			}
		}
		
		return 0;
	}
}

