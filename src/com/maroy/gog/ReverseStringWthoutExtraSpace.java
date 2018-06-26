package com.maroy.gog;

public class ReverseStringWthoutExtraSpace {

	public static void main(String[] args) {

		String str = "ABCDE";
		
		System.out.println(reverse(str.substring(1, str.length()), str.charAt(0)));

	}

	private static String reverse(String str, char c) {

		if(str.isEmpty())
			return ""+c;
		
		return reverse(str.substring(1, str.length()), str.charAt(0))+c;
	}

}
