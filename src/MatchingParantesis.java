
public class MatchingParantesis {

	public static void main(String[] args) {

		matchP("((sdfsddgfs)) (sdsdsdsd(dsfdsdfsdfs(sdsdsdsd)sdfsdfsdf) (ssdfseess))", 4);
		matchP("((sdfsddgfs)) (sdsdsdsd(dsfdsdfsdfs(sdsdsdsd)sdfsdfsdf) (ssdfseess))", 2);
		matchP("(sdfsddgfs (sdsdsdsd(dsfdsdfsdfs(sdsdsdsd)sdfsdfsdf) ssdfseess))", 4);
	}
	static void matchP(String input, int value){
		
		int bracesCount = 0,openBraces = 0;
		int output = 0;
		for(int i=0;i<input.length();i++){
			
			if(input.charAt(i)=='('){
				bracesCount++;
				openBraces++;
			}
			else if(input.charAt(i)==')'){
				
				if(openBraces == value && output==0){
					output = i+1;
				}
				else if(openBraces>value){
					openBraces--;
				}
				bracesCount--;
			}
		}
		if(bracesCount !=0){
			System.out.println(-1);
		}
		else{
			System.out.println(output);
		}
	}
}
