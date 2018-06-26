package com.maroy.gog;

import java.util.Scanner;

public class MinimumPlatform {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
        int noOfTests = scanner.nextInt();

        for(int i=0;i<noOfTests;i++){
        	
        	int size = scanner.nextInt();
        	int[] arr = new int[size];
        	int[] dep = new int[size];
        	int j = 0;
        	while(j<size){
        		
        		arr[j++] = scanner.nextInt();
        	}
        	j=0;
        	while(j<size){
        		
        		dep[j++] = scanner.nextInt();
        	}
        	
        	int a = 1,b=0,platform_needed = 1,result=1;

        	while(a<size && b<size){
        		if(arr[a] < dep[b]){
        			platform_needed++;
        			a++;
        		}
        		else{
        			platform_needed--;
        			b++;
        		}
        		if(platform_needed>result)
        			result = platform_needed;
        	}
        	System.out.println(result);
        }
        scanner.close();
	}
}
