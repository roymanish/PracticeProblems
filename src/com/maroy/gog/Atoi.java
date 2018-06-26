package com.maroy.gog;

public class Atoi {

	public static void main(String[] args) {

		System.out.println(atoi("123"));
		System.out.println(atoi("21a"));
	}
	private static int atoi(String str){
		
		try{
			int i = Integer.parseInt(str);
			return i;
		}
		catch(NumberFormatException nfe){
			return -1;
		}
	}
}
