package com.maroy.hackerrank;

import java.util.Scanner;

public class SherlockAndAnagram {

	static int sherlockAndAnagrams(String s){

		String sub1 = "";
		String sub2 = "";
		int count = 0;
		for(int len = 1;len<s.length();len++) {
			
			for(int i = 0;i<s.length()-len;i++) {
				
				sub1 = s.substring(i, i+len);
				for(int j=i+1;j<s.length()-len+1;j++) {
					
					sub2 = s.substring(j,j+len);
					int result = checkAnagram(sub1, sub2);
					if(result == 1)
						count++;
				}
			}
		}
		return count;
    }

    private static int checkAnagram(String sub1, String sub2) {
    	
    	char[] a = sub1.toCharArray();
    	char[] b = sub2.toCharArray();
    	
    	int[] first = new int[26], second = new int[26];
    	int c = 0;

    	   while (c<sub1.length()) {
    	      first[a[c]-'a']++;
    	      c++;
    	   }
    	   c = 0;
    	   while (c<sub2.length()) {
    	      second[b[c]-'a']++;
    	      c++;
    	   }

    	   for (c = 0; c < 26; c++) {
    	      if (first[c] != second[c])
    	         return 0;
    	   }

    	   return 1;
	}

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = sherlockAndAnagrams(s);
            System.out.println(result);
        }
    }

}
