/**
 * 
 */
package com.maroy.random.probs;

/**
 * @author MaRoy
 *
 */
public class RecursionExampleClass {

	public static void main(String[] args){
		
		RecursionExampleClass rc = new RecursionExampleClass();
		rc.recursiveMethod(10);
	}
	
	public void recursiveMethod(int value){
		
		value--;
		if(value <= 0)
			return;
		
		recursiveMethod(value);
		System.out.println(value);
		System.out.println("Recursion Ends");
	}
}
