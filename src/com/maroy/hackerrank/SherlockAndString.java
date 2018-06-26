package com.maroy.hackerrank;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SherlockAndString {

static String isValid(String s){
        
        int i = 0;
        if(s.length() == 1)
            return "NO";
        
        Map<Integer, List<Character>> charMap = new HashMap<>();
        while(i<s.length()){
        	
            char ch = s.charAt(i);
            int count = s.length() - s.replace(""+ch,"").length();
            i = i+count;
            
            if(charMap.containsKey(count)){
                charMap.get(count).add(ch);
            }
            else{
            	List<Character> list = new ArrayList<>();
            	list.add(ch);
                charMap.put(count, list);
            }
        }
        
        if(charMap.keySet().size() == 1){
            return "YES";
        }
        
        if(charMap.keySet().size() == 2){
            
            int firstCnt = (int) charMap.keySet().toArray()[0];
            int secCnt = (int) charMap.keySet().toArray()[1];
            
            if(Math.abs(firstCnt - secCnt) == 1 && Math.abs(charMap.get(firstCnt).size() - charMap.get(secCnt).size()) == 1)
                return "YES";
        }
        
        return "NO";
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = isValid(s);
        System.out.println(result);
    }

}
