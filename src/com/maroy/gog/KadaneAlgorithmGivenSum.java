package com.maroy.gog;

import java.util.Scanner;

public class KadaneAlgorithmGivenSum {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
        int noOfTests = scanner.nextInt();

        for(int i=0;i<noOfTests;i++){
        	
        	int size = scanner.nextInt();
        	int sum = scanner.nextInt();
        	int[] arr = new int[size];
        	
        	int j = 0;
        	while(j<size){
        		
        		arr[j++] = scanner.nextInt();
        	}
        	

            //int size = a.length;
            int max_ending_here = 0;
            int start = 1,end = 1,k=0;
            while(k<size)
            {
                max_ending_here = max_ending_here + arr[k];
                
                if(max_ending_here > sum){
                	start = end = start+1;
                	k = start-1;
                	max_ending_here = 0;
                	//end = start;
                }
                else if(max_ending_here == sum){
                	System.out.println("Start : "+start+" End : "+end+"\n");
                	break;
                }
                else{
                	end = end + 1;
                	k++;
                }
            }
        System.out.println("-1");
        }
        scanner.close();
		//maxSubArraySum(new int[]{1,2,3,4,5,6,7,8,9,10}, 15);
	}
	
	static void maxSubArraySum(int a[], int sum)
    {
        int size = a.length;
        int max_ending_here = 0;
        int start = 1,end = 1,i=0;
        while(i<size)
        {
            max_ending_here = max_ending_here + a[i];
            
            if(max_ending_here > sum){
            	start = end = start+1;
            	i = start-1;
            	max_ending_here = 0;
            	//end = start;
            }
            else if(max_ending_here == sum){
            	System.out.println("Start : "+start+" End : "+end);
            	break;
            }
            else{
            	end = end + 1;
            	i++;
            }
        }
    }
}
