/**
 * 
 */
package com.maroy.random.probs;

import java.util.Stack;

/**
 * @author MaRoy
 *
 */
public class ParanthesisBalancing {

	public static void main(String[] args){

		String str = "[]{}()";
		String output = braces(str);
		System.out.println(output);


	}

	static String braces(String value) {

		Stack<Character> stack = new Stack<Character>();
		String output = "YES";
		for(int i=0;i<value.length();i++){
			
			if(value.charAt(i) == ']' || value.charAt(i) == '}' || value.charAt(i) == ')'){
				
				if(stack != null &&!stack.isEmpty()){
					
					if(!isMatchingPair(stack.pop(), value.charAt(i)))
						output = "NO";
				}
			}
			else if(value.charAt(i) == '[' || value.charAt(i) == '{' || value.charAt(i) == '('){
				
				stack.push(value.charAt(i));
			}
		}
		
		if(value.charAt(value.length()-1) == '[' || value.charAt(value.length()-1) == '{' || value.charAt(value.length()-1) == '(')
			output = "NO";
		return output;
	}
	
	static boolean isMatchingPair(char opening, char closing){
		
		if(opening == '(' && closing == ')')
			return true;
		else if(opening == '{' && closing == '}')
			return true;
		else if(opening == '[' && closing == ']')
			return true;
		return false;
	}
}
