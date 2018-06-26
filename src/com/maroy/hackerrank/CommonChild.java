package com.maroy.hackerrank;

import java.util.Scanner;

public class CommonChild {

	static int commonChild(String s1, String s2){

		int result = 0;
		int currIndex = Integer.MIN_VALUE;
		int len = Math.min(s1.length(), s2.length());
		StringBuilder sb2 = new StringBuilder(s2);
		for(int i=0;i<len;i++) {
			
			char c = s1.charAt(i);
			
			if(s2.indexOf(c) != -1 && s2.indexOf(c) > currIndex) {
				currIndex = s2.indexOf(c);
				result++;
				sb2.setCharAt(currIndex, '#');
			}
		}
		return result;	
    }

	static int commonChild2(String a, String b){
        int[][] C = new int[a.length()+1][b.length()+1];

        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    C[i+1][j+1] = C[i][j] + 1;
                } else {
                    C[i+1][j+1] = Math.max(C[i+1][j], C[i][j+1]);
                }
            }
        }
        for (int i = 0; i < a.length(); i++) {
        }

        return C[a.length()][b.length()];
    }
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        //int result = commonChild(s1, s2);
        int result = commonChild2(s1, s2);
        System.out.println(result);
    }
}
