package com.maroy.random.probs;

public class AddDecimalStrings {

	public static void main(String[] args) {

		String num1 = "1222"; //18
		String num2 = "2333"; //21

		/**Output Expected 3555*/
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
		int carry = 0;
		for(int i = num1.length()-1;i>=0;i--){

			int n1 = num1.charAt(i)-'0';
			int n2 = num2.charAt(i)-'0';

			int sum = n1+n2+carry;
			carry = sum>=10 ? 1 : 0;

			output = output.append(sum);
		}

		if(carry>0)
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
