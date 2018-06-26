package com.maroy.gog;

public class FindKLargest {

	public static void main(String[] args) {
		
		int[] arr = new int[]{1,3,5,4,2,7,13,8};
		int k = 5;

		findKLargest(arr, k);

		for(int i=0;i<k;i++){
			
			System.out.print(arr[i]);
		}
	}
	
	private static void findKLargest(int[] arr, int k){
		
		for(int i = k/2-1;i>=0;i--){
			
			heapify(arr, i, 5);
		}
		
		while(k<arr.length){
			if(arr[k] > arr[0]){

				int temp = arr[0];
				arr[0] = arr[k];
				arr[k] = temp;
			}
			k++;
			findKLargest(arr, k);
		}
	}
	private static void heapify(int[] arr, int n, int size){
		
		int smallest = n;
		int left = 2*n+1;
		int right = 2*n+2;
		
		if(left<size && arr[left] < arr[smallest]){
			smallest = left;
		}
		
		if(left<size && arr[right] < arr[smallest]){
			smallest = right;
		}
		
		if(smallest != n){
			
			int temp = arr[smallest];
			arr[smallest] = arr[n];
			arr[n] = temp;
		}
	}

}
