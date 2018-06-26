package com.maroy.gog;

//Java program to print all permutations of a
//given string.
public class StringPermutation
{
	public static void main(String[] args)
	{
		String str = "ABCD";
		int n = str.length();
		//StringPermutation permutation = new StringPermutation();
		//permutation.permute(str, 0, n-1);
		//allSubstring(str);
		permute1(str, "");
	}

	/**
	 * permutation function
	 * @param str string to calculate permutation for
	 * @param l starting index
	 * @param r end index
	 */
	private void permute(String str, int l, int r)
	{
		if (l == r)
			System.out.println(str);
		else
		{
			for (int i = l; i <= r; i++)
			{
				str = swap(str,l,i);
				permute(str, l+1, r);
				str = swap(str,l,i);
			}
		}
	}

	/**
	 * Swap Characters at position
	 * @param a string value
	 * @param i position 1
	 * @param j position 2
	 * @return swapped string
	 */
	public String swap(String a, int i, int j)
	{
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i] ;
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}
	
	public static void allSubstring(String s) {
		int n = s.length();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				
				if(i!=j) {
					s = swapChar(s,i,j);
					System.out.println(s);
				}
			}
		}
	}

	private static String swapChar(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i] ;
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
		
	}
	
	private static void permute1(String str, String chosen) {
		
		if(str.isEmpty())
			System.out.println(chosen);
		else {
			for(char c : str.toCharArray()) {
				chosen += c;
				int indexOfC = str.indexOf(c);
				str = str.substring(0, indexOfC) + str.substring(indexOfC+1, str.length());
				permute1(str, chosen);
				str = c+str;
				chosen = chosen.replace(chosen.charAt(chosen.length()-1)+"", "");
			}
		}
	}

}

