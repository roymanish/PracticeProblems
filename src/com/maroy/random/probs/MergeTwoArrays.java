/**
 * 
 */
package com.maroy.random.probs;

/**
 * @author MaRoy
 *
 */
public class MergeTwoArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] a = new int[]{10,20,30,40,50};
		int[] b = new int[]{15,22,25,45,75,0,0,0,0,0};

		mergeArrays(a, b, a.length);

		for(int j = 0; j<b.length;j++){
			System.out.println(b[j]);
		}
	}

	static void mergeArrays(int[] a, int[] b, int size){

		//int[] c = new int[2*size];
		
		for(int i = 0;i<a.length;i++){
			
			if(a[i]<b[i]){
				
				int j =a.length;
				while(j!=i){
					b[j] = b[j-1];
					j--;
				}
				b[j] = a[i];
			}
			
		}

		/*for(int i=0,l=0;i<b.length&&l<a.length;i++){

			if(l < a.length){
				
				if(a[l] < b[i]){
					
					while()
					int temp = b[i];
					b[i] = a[l];
					
				}
				else{

					c[i] = b[k];
					k++;
				}
			}

			else if(l<k){

				while(l<a.length)
					c[i++] = a[l++];
			}
			else{
				while(k<b.length)
					c[i++] = b[k++];
			}
		}
		b = c;*/
	}


}
