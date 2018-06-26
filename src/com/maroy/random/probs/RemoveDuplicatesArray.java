/**
 * 
 */
package com.maroy.random.probs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author MaRoy
 *
 */
public class RemoveDuplicatesArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Integer[] arr = new Integer[]{1,1,1,2,33,55,33,44,78,99,2,3,3,2,1,78};
		
		Set<Integer> uniqueSet = new HashSet<Integer>(Arrays.asList(arr));
		
		Iterator<Integer> set = uniqueSet.iterator();
		
		while(set.hasNext())
			System.out.print(set.next()+" ");

	}

}
