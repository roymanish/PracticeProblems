
public class CountString {

	public static void main(String[] args) {

		String str = "My name is Manish.Manish is a super man.Manish is good husband. Manish His wife calls him Manish.";
		
		int lengthOfString = str.length();
		
		String newString = str.replace("Manish","");
		
		System.out.println( (lengthOfString - newString.length()) / "Manish".length());
	}

}
