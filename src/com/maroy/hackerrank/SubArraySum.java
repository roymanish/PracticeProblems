package com.maroy.hackerrank;

import java.util.Scanner;

public class SubArraySum {

	static long maximumSum(long[] a, long m) {

		long cummulativeSum = 0;
		long[] sumArr = new long[a.length];
		for(int k = 0;k<a.length;k++) {
			cummulativeSum = cummulativeSum + a[k];
			sumArr[k] = cummulativeSum;
		}
		long maxModulo = 0;
		
		for(int len=1;len<=a.length;len++) {
			int i=0,j=len-1;
			while(j<a.length) {
				
				long sum = 0;
				
				if(i==j)
					sum = a[i];
				else if(i==0) {
					sum = sumArr[j];
				}
				else {
					sum = sumArr[j] - sumArr[i-1];
				}
				
				if(sum%m >= maxModulo)
					maxModulo = sum%m;
				i++;
				j++;
			}
			
		}
		
		/*for(int len=1;len<=a.length;len++) {
			int i=0,j=len-1;
			while(j<a.length) {
				
				long sum = 0;
				while(i<=j) {
					sum = sum+a[i];
					i++;
				}
				
				if(sum%m >= maxModulo)
					maxModulo = sum%m;
				i = i-len+1;
				j = i+len-1;
			}
			
		}*/
		return maxModulo;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            long m = in.nextLong();
            long[] a = new long[n];
            for(int a_i = 0; a_i < n; a_i++){
                a[a_i] = in.nextLong();
            }
            long result = maximumSum(a, m);
            System.out.println(result);
        }
        in.close();
    }
}
