package com.maroy.gog;

import java.util.Arrays;

public class MaxHeapExample {

	public static void main(String[] args) {
		
		int[] arr = new int[]{1,4,3,7,8,9,10};// new int[]{10, 8, 9, 7, 4, 1, 3};
		int size = arr.length;

		for(int i=size/2-1;i>=0;i--){
			
			max_heapify(arr, i);
		}
		System.out.println(Arrays.toString(arr));
	}

	static void max_heapify(int[] arr, int i){
		
		int largest = i;
		int left = 2*i+1;
		int right = 2*i+2;
		if(left<arr.length && arr[left] > arr[i]){
			largest = left;
		}
		
		if(right<arr.length && arr[right] > arr[largest]){
			largest = right;
		}
		
		if(largest != i){
			
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			max_heapify(arr, largest);
		}
	}
}
