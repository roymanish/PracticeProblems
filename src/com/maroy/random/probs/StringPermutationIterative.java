/**
 * 
 */
package com.maroy.random.probs;

/**
 * @author MaRoy
 *
 */
public class StringPermutationIterative {

	public static void main(String[] args){
		
		String str = "ABCDE";
		getAllPermutationsOfString(str);
	}
	
	public static void getAllPermutationsOfString(String str){
		
		for(int i=0;i<str.length();i++){
			
			String fixPart = String.valueOf(str.charAt(i));
			String varPart = str.substring(0,i)+str.substring(i+1);
			//char[] varArr = new char[varPart.length()];
			
			for(int j=0;j<varPart.length();j++){
				
				System.out.println(fixPart+varPart.charAt(j)+varPart.substring(0,j)+varPart.substring(j+1));
			}
			//System.out.println(fixPart+varPart);
		}
	}
}
