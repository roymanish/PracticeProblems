package com.maroy.random.probs;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AllPalindromeInAString {
  /*
 * Complete the function below.
 */

    static int palindrome(String str) {
    	
    	Set<CharSequence> out = new HashSet<CharSequence>();
    	out.add(String.valueOf(str.charAt(0)));
    	for(int i=1;i<str.length();i++){
    		
    		int j=1;
    		if(str.charAt(i) == str.charAt(i-1)){
    			out.add(String.valueOf(str.charAt(i))+String.valueOf(str.charAt(i)));
    			
    			while(((i-j-1) >=0)&&((i+j)<str.length())&& j<=i && (str.charAt(i-j-1) == str.charAt(i+j))){
        			out.add(str.subSequence(i-j-1, i+j+1));
        			j++;
        		}
    		}
    		
    		//Takes care of single characters
    		out.add(String.valueOf(str.charAt(i)));
    		
    		j=1;
    		while(((i+j)<str.length())&& j<=i && (str.charAt(i-j) == str.charAt(i+j))){
    			out.add(str.subSequence(i-j, i+j+1));
    			j++;
    		}
    	}
    	System.out.println(out);
    	return out.size();
    }
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        int res;
        String _str;
        try {
            _str = in.nextLine();
        } catch (Exception e) {
            _str = null;
        }
        
        res = palindrome(_str);
        System.out.println(res);
    }
}