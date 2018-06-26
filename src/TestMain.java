import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TestMain {

	
	public static void main(String[] args) {
		
		Set<String> listOfName = new HashSet<>();
		listOfName.add("ABC");
		listOfName.add("PQR");
		listOfName.add("DEF");
		
		System.out.println(listOfName);
		
		//listOfName.remove("PQR");
		
		Iterator<String> itr = listOfName.iterator();
		
		while(itr.hasNext()) {
			
			String str = itr.next();
			if(str.equalsIgnoreCase("PQR"))
				itr.remove();
		}
		System.out.println(listOfName);
	}

}
