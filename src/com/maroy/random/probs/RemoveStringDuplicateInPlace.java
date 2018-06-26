/**
 * 
 */
package com.maroy.random.probs;

/**
 * @author MaRoy
 *
 */
public class RemoveStringDuplicateInPlace {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String input = "FOOOOOOOOLLLLLOWWWWWWWWWWUUUUP";
		
		String output = RemoveStringDuplicateInPlace.removeDuplicates(input);
		
		System.out.println(output);

	}
	
	static String removeDuplicates(String s) {
	    StringBuilder noDupes = new StringBuilder();
	    for (int i = 0; i < s.length(); i++) {
	        String si = String.valueOf(s.charAt(i));
	        if (noDupes.indexOf(si) == -1) {
	            noDupes.append(si);
	        }
	    }
	    return noDupes.toString();
	}

}
