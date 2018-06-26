import java.util.HashMap;
import java.util.Map;

public class TheToss {

	private static Map<String, String> tossDecisionMap = new HashMap<>();
	static {
		tossDecisionMap.put("LengaBuruClearDay", "Bats");
		tossDecisionMap.put("LengaburuCloudyNight", "Bowls");
		tossDecisionMap.put("EnchaiClearDay", "Bowls");
		tossDecisionMap.put("EnchaiCloudyNight", "Bats");
	}
	public static void main(String[] args) {

		//Map<String, String> tossDecisionMap = new HashMap<>();
		
		String output = tossDecisionMap.get("LengaburuCloudyNight1");
		System.out.println(output);
	}
	
	public static String getTossResult(){
		
		int randomResult = (int )(Math.random() * 10 + 1);
		if(randomResult % 2 == 0)
			return "Lengaburu";
		else
			return "Enchai";
	}
}
