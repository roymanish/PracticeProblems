
public class DemoSingleton {

	public static void main(String[] args) {
		Singleton.INSTANCE.someMethod();

	}

}
enum Singleton {
	
    INSTANCE;
    
    public void someMethod() {
    	System.out.println("Inside Some method!");
    }
}
