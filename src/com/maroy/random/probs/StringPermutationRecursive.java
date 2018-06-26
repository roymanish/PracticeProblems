package com.maroy.random.probs;

public class StringPermutationRecursive {

	private static void permutation(String prefix, String str){
        int n = str.length();
        if (n == 0) 
            System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), 
            str.substring(0, i) + str.substring(i+1));
        }
    }
    public static void main(String[] args) {
        permutation("", "ABCD");
    }
}
/*
 * ""  ABCD 4
 * A   BCD  3
 * AB   CD  2
 * ABC   D  1
 * ABCD ""  0
 */