package com.maroy.gog;

public class PythagorianTriplet {

	public static void main(String[] args) {

		int[] arr = new int[]{};
		
		for(int i = 0;i<arr.length;i++){
			
			int first = arr[i]*arr[i]; 
					
			for(int j = 1;j<arr.length;j++){
				
				int second = arr[j]*arr[j];
				
				double third = Math.sqrt(first + second);
			}
		}
	}

}
