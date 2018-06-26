package com.maroy.gog;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class FindMinDifferencePair {

	public static void main(String[] args) {

		int[] arr = new int[] {40,100,30,200,29,98,150,25};
		
		System.out.println(maxProfit(arr));

	}
	
	public static int maxProfit(final int[] A) {
        int minB=Integer.MAX_VALUE;
        int maxS = Integer.MIN_VALUE;
        int loss = 0;
        int profit=0;
        for(int i=1 ;i< A.length; i++){
        	
        	if(A[i] > maxS)
        		maxS = A[i];
        	
        	int minLoss = maxS - A[i];
        	
        	if(minLoss < loss)
        		loss = minLoss;
            /*if(A[i] <minB){
                minB=A[i];
            }
            int tempProfit=A[i]-minB;
            if(tempProfit >profit){
                profit=tempProfit;
            }*/
        }
        
        return loss;
    }

}
