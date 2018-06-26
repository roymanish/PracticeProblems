package com.maroy.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class HackerlandRadioTransmitter {

	static int hackerlandRadioTransmitters(int[] x, int k) {
        
		int noOfTransmitters = 0;
		int curr = 0;
		int next = 1;
		
		Arrays.sort(x);
		
		while(next < x.length) {

			if(x[next] == (x[curr]+k)) {
				noOfTransmitters++;
			}
			curr++;
			next = curr+1;
		}
		return noOfTransmitters;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] x = new int[n];
        for(int x_i = 0; x_i < n; x_i++){
            x[x_i] = in.nextInt();
        }
        int result = hackerlandRadioTransmitters(x, k);
        System.out.println(result);
        in.close();
    }
}
