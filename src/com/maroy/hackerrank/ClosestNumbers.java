package com.maroy.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class ClosestNumbers {

	static int[] closestNumbers(int[] arr) {
        Arrays.sort(arr);
        
        int minDiff = Integer.MAX_VALUE;
        
        for(int i = 1;i < arr.length;i++){
            if((arr[i]-arr[i-1]) < minDiff)
                minDiff = (arr[i]-arr[i-1]);
        }
        
        for(int j = 1;j < arr.length;j++){
            if((arr[j]-arr[j-1]) == minDiff)
                System.out.print(arr[j-1]+" "+arr[j]+" ");
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int[] result = closestNumbers(arr);

        in.close();
    }
}
