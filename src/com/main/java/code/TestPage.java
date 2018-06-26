package com.main.java.code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TestPage {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        
        int index = 0;
        while(st.hasMoreTokens()){
        	arr[index++] = Integer.parseInt(st.nextToken());
        }
        
        int sumOut = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        
        int counter = 0;
        
        for (int j = 0;j<N;j++){
        	
        	if(arr[j] >= sumOut){
        		counter++;
        	}
        	int sum = 0;
        	for (int i = 0; i < N; i++) {
        		
        		if(i==j)
        			continue;
        		sum = sum + arr[j] + arr[i];
        		if(sum>=sumOut)
        			counter++;
        		
        	}
        }
        System.out.println(counter);
	}

}
