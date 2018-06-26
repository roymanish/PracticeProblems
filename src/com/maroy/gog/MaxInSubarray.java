package com.maroy.gog;

import java.util.Scanner;

public class MaxInSubarray {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
        int noOfTests = scanner.nextInt();

        for(int i=0;i<noOfTests;i++){
        	
        	int size = scanner.nextInt();
        	int subarray = scanner.nextInt();
        	int[] arr = new int[size];
        	int j = 0;
        	while(j<size){
        		
        		arr[j++] = scanner.nextInt();
        	}
        	
        	int k,max;
        	for (int l = 0; l <= size-subarray; l++)
            {
                max = arr[l];
         
                for (k = 1; k < subarray; k++)
                {
                    if (arr[l+k] > max)
                       max = arr[l+k];
                }
                System.out.print(max+" ");
            }
        	System.out.println();
        }
        scanner.close();
	}

}
