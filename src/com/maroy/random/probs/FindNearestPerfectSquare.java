/**
 * 
 */
package com.maroy.random.probs;

/**
 * @author MaRoy
 *
 */
public class FindNearestPerfectSquare {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int num = 1021;
		
		findNearestSquare(num);
		
	}
	
	public static void findNearestSquare(int num){
		
		if(num == 2)
			System.out.println(2);
		if(num == 1)
			System.out.println(1);

		int tempNum = num;
		while(tempNum*tempNum > num){
			
			tempNum = tempNum/2;
		}
		
		int extra = tempNum*2;
		int output = 0;
		if((extra*extra-num) > (num-(extra-1)*(extra-1))){
			
			output = (extra-1)*(extra-1);
		}
		else{
			output = extra*extra;
		}
		System.out.println(output);
	}
	
}
