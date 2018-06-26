
public class MyAnnotation {

	public static void main(String[] args) {
		
		String str = "Remove spaces in a string without using inbuilt function and taking constant space";
		StringBuilder sb = new StringBuilder();
		
		int i = 0;
		while(i<str.length()){
			
			if(str.charAt(i) != ' '){
				
				sb.append(str.charAt(i));
			}
			i++;
		}
		System.out.println(sb.toString());
	}
}
