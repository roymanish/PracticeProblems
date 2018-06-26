/**
 * 
 */
package com.maroy.random.probs;

/**
 * @author MaRoy
 *
 */
public class QuickSort {

	public static void main(String[] args){
		
		int[] inputArr = {45,23,11,89,77,98,4,28,65,43};
		
		quickSort(inputArr, 0, inputArr.length-1);
		
		for(int i : inputArr){
			
			System.out.print(i+" ");
		}
	}
	public static void quickSort(int[] arr, int start, int end){
		
		if(start<end){
			
			int partitionIndex = partition(arr, start, end);
			quickSort(arr, start, partitionIndex-1);
			quickSort(arr, partitionIndex+1, end);
		}
	}
	
	public static int partition(int[] arr, int start, int end){
		
		int pivot = arr[end];
		int partitionIndex = start;
		
		for(int i=start;i<=end-1;i++){
			
			if(arr[i] <= pivot){
				
				int temp = arr[i];
				arr[i] = arr[partitionIndex];
				arr[partitionIndex] = temp;
				partitionIndex++;
			}
		}
		int temp = arr[end];
		arr[end] = arr[partitionIndex];
		arr[partitionIndex] = temp;
		return partitionIndex;
	}
}
