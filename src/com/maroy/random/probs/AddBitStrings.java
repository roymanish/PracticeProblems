/**
 * 
 */
package com.maroy.random.probs;

/**
 * @author MaRoy
 *
 */
public class AddBitStrings {

	public static void main(String[] args) {
		
		String num1 = "10010"; //18
		String num2 = "101"; //5
		
		/**Output Expected 10111 - 23*/
		System.out.println("Number 1: "+num1);
		System.out.println("Number 2: "+num2);
		String output = addBitStrings(num1, num2);
		System.out.println("Sum Output : "+output);
	}
	
	private static String addBitStrings(String num1, String num2){
		
		if(num1.length() > num2.length()){
			
			num2 = makeEqualLength(num2, num1.length()-num2.length());
		}
		else{
			num1 = makeEqualLength(num1, num2.length()-num1.length());
		}
		
		String output = calculateSum(num1, num2);
		return output;
	}
	
	private static String calculateSum(String num1, String num2){
		
		StringBuilder output = new StringBuilder();
		char carry = '0';
		for(int i = num1.length()-1;i>=0;i--){
			
			char c1 = num1.charAt(i);
			char c2 = num2.charAt(i);
			
			if(c1!=c2){
				
				output.append("1");
				carry = '0';
			}
			else if(c1 == c2){
				
				output.append(carry);
				carry = c1;
			}
		}
		if(carry>'0')
			output.append(carry);
			
		return output.reverse().toString();
	}
	
	private static String makeEqualLength(String num, int len){
		
		while(len>0){
			num = "0"+num;
			len--;
		}
		return num;
	}
}
