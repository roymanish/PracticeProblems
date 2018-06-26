package com.maroy.gog;

import java.util.Scanner;

public class KadaneAlgorithm {

	public static void main(String[] args){

		/*//Scanner scanner = new Scanner(System.in);
        int noOfTests = scanner.nextInt();

        int gmax = 0;
        for(int i=0;i<noOfTests;i++){
        	
        	int size = scanner.nextInt();
        	int[] arr = new int[size];
        	
        	int j = 0;
        	while(j<size){
        		
        		arr[j++] = scanner.nextInt();
        	}
        	
        	gmax = maxSubArraySum(new int[]{-2, -3, 4, -1, -2, 1, 5, -3});
        	
        	System.out.println(gmax+"\n");
        }
        scanner.close();*/
		
		int gmax = maxSubArraySum(new int[]{-2, -3, -4, -1, -2, -3});
    	System.out.println(gmax+"\n");
    	
    	gmax = maxSubArraySum(new int[]{-2, -3, 4, -1, -2, 1, 5, -3});
    	System.out.println(gmax+"\n");
	}
	static int maxSubArraySum(int a[])
    {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
 
        for (int i = 0; i < size; i++)
        {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }

}
