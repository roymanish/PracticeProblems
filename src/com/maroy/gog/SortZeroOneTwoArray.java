package com.maroy.gog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortZeroOneTwoArray {

	public static void main(String[] args) {
		
		//sort012();
		
		int[] arr = new int[] {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		sort012Dutch(arr);
		printArray(arr);
	}

	private static void sort012() {
		Scanner scanner = new Scanner(System.in);
        int noOfTests = scanner.nextInt();

        for(int i=0;i<noOfTests;i++){
        	
        	int size = scanner.nextInt();
        	List<Integer> arrList = new ArrayList<>();
        	
        	int j = 0;
        	while(j<size){
        		
        		arrList.add(scanner.nextInt());
        		j++;
        	}
        	Collections.sort(arrList);
        	
        	for(Integer l : arrList){
        		
        		System.out.println(l+" ");
        	}
        	System.out.println();
        }
        scanner.close();
	}
	
	private static void sort012Dutch(int[] arr) {
		
		int lo = 0;
		int mid = 0,temp=0;
		int hi = arr.length-1;
		
		while(mid<=hi) {
			
			switch(arr[mid]) {
			
				case 0:
				{
					temp = arr[lo];
					arr[lo] = arr[mid];
					arr[mid] = temp;
					lo++;
					mid++;
					break;
				}
				case 1:
				{
					mid++;
					break;
				}
				case 2:
				{
					temp = arr[hi];
					arr[hi] = arr[mid];
					arr[mid] = temp;
					hi--;
					break;
				}
				
			}
		}
	}

	private static void printArray(int arr[])
    {
        int i;
        for (i = 0; i < arr.length; i++)
            System.out.print(arr[i]+" ");
        System.out.println("");
    }
}
