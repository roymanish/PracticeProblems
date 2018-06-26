package com.maroy.gog;

import java.util.Arrays;
import java.util.Scanner;

public class FindNonRepeatingNumber {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int noOfTests = scanner.nextInt();

		for(int i=0;i<noOfTests;i++){

			int size = scanner.nextInt();
			//int sum = scanner.nextInt();
			int[] arr = new int[size];

			int j = 0;
			while(j<size){

				arr[j++] = scanner.nextInt();
			}
			//int[] arr = new int[]{1,1,2,2,3,3,4,50,50,65,65};

			int k=0;

			boolean found = false;
			while(k<arr.length-2){

				if(arr[k] != arr[k+1]){
					found = true;
					System.out.print(arr[k]);
					break;
				}
				k=k+2;
			}

			if(!found)
				System.out.print(arr[k]);
			
			System.out.println();
		}
		scanner.close();
	}

}
