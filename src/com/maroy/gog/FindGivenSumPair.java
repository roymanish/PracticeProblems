package com.maroy.gog;

import java.util.HashMap;
import java.util.Map;

public class FindGivenSumPair {

	public static void main(String[] args) {
		
		int[] arr = new int[] {1,3,46,1,3,9};
		long k = 47;
		int k1 = (int)k;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(Integer i : arr) {
			
			if(map.containsKey(k1-i)) {
				if(map.get(k1-i) == null)
					map.put(i, k1-i);
			}
			else {
				map.put(i, null);
			}
		}
		System.out.println(map);

	}

}
