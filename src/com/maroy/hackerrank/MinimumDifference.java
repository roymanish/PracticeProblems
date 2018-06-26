package com.maroy.hackerrank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MinimumDifference {

static int minimumLoss(Long[] price, Map<Long, Integer> indexMap) {
        
        long result = Integer.MAX_VALUE;
        Arrays.sort(price, new Comparator<Long>() {

			@Override
			public int compare(Long o1, Long o2) {
				return o2.compareTo(o1);
			}
		});
        
        for(int i=0;i<price.length-1;i++){
        	
        	if((price[i]-price[i+1])<result && indexMap.get(price[i]) < indexMap.get(price[i+1])){
                result = (price[i]-price[i+1]);
            }
        }
        return (int)result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Long[] price = new Long[n];
        Map<Long, Integer> indexMap = new HashMap<Long, Integer>();
        for(int price_i = 0; price_i < n; price_i++){
            price[price_i] = in.nextLong();
            indexMap.put(price[price_i], price_i);
        }
        int result = minimumLoss(price, indexMap);
        System.out.println(result);
        in.close();
    }
}
