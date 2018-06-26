package com.main.java.code;

public class CodeAThon {

	public static void main(String[] args) {
		
		String str = "7879327765848469823284726932696779787977893279703284726932748578717669327332676578327869866982326965843271826583833273848332787984328082736869327384833274858384328772793273326577";
		String newStr = "";
		
		for(int i=0;i<str.length()-2; i=i+2){
			newStr = newStr+Character.toString((char)Integer.parseInt(str.substring(i, i+2)));
		}
		System.out.println(newStr);
	}
}
