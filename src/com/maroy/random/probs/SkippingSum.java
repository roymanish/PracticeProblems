/**
 * 
 */
package com.maroy.random.probs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author MaRoy
 *
 */
public class SkippingSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line);

		int N = 0;

		if(st.hasMoreTokens())
			N = Integer.parseInt(st.nextToken());

		int q = 0;
		if(st.hasMoreTokens())
			q = Integer.parseInt(st.nextToken());

		String input1 = br.readLine();

		String[] intArr = input1.split(" ");

		while(q != 0){
			String input2 = br.readLine();

			StringTokenizer st2 = new StringTokenizer(input2);
			int L = 0;
			if(st2.hasMoreTokens())
				L = Integer.parseInt(st2.nextToken());

			int R = 0;
			if(st2.hasMoreTokens())
				R = Integer.parseInt(st2.nextToken());

			int K = 0;
			if(st2.hasMoreTokens())
				K = Integer.parseInt(st2.nextToken());

			int sum = 0;

			while(L<=R){
				sum = sum + Integer.parseInt(intArr[L-1]);
				L = L + K;
			}
			System.out.println(sum);
			q--;
		}
	}
}
