package com.maroy.gog;

import java.util.Scanner;

public class ArraySumEquilibriumPoint {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
        int noOfTests = scanner.nextInt();

        for(int i=0;i<noOfTests;i++){
        	
        	int size = scanner.nextInt();
        	int[] arr = new int[size];
        	int j = 0;
        	while(j<size){
        		
        		arr[j++] = scanner.nextInt();
        	}
        	
        	int leftSum = arr[0],rightSum = arr[size-1];
        	boolean found = false;
        	int k=1,l=size;
        	while(k<l){
        		
        		if(leftSum < rightSum){
        			k = k+1;
        			leftSum = leftSum + arr[k-1];
        		}
        		else if(rightSum < leftSum){
        			l = l-1;
        			rightSum = rightSum + arr[l-1];
        		}
        		else{
        			if(l-k==2 || l-k == 0){
        				found = true;
        				break;
        			}
        		}
        		
        	}
        	if(found){
        		System.out.print(k+1);
        	}
        	else
        		System.out.print(-1);
        	System.out.println();
        }
        scanner.close();
	}

}
