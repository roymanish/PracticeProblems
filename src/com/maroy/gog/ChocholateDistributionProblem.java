package com.maroy.gog;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ChocholateDistributionProblem {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int noOfTests = scanner.nextInt();

		for(int t=0;t<noOfTests;t++){

			int size = scanner.nextInt();
			Integer[] arr = new Integer[size];
			int j = 0;
			while(j<size){

				arr[j++] = scanner.nextInt();
			}

			int m = scanner.nextInt();

			Collections.sort(Arrays.asList(arr));

			int diff = arr[m-1]-arr[0];
			for(int i=0;i<arr.length-m+1;i++){

				if(diff > arr[i+m-1]-arr[i]){
					diff = arr[i+m-1]-arr[i];
				}
			}
			System.out.print(diff);
			System.out.println();
		}
		scanner.close();
	}
	
}
