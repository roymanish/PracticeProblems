import java.io.IOException;

public class AbstractClassTest {

	public static void main(String[] args) {
		
		//MyAbstract obj1 = new MyAbstract() 
		MyConcrete obj = new MyConcrete();
		try {
			obj.throwExample(10);
		} catch (IOException e) {
			System.out.println("Exception Handled");
		}
	}
}
abstract class MyAbstract{
	
	public MyAbstract() {
		System.out.println("Inside Abstract constructor!!");
	}
}

class MyConcrete extends MyAbstract{
	
	public MyConcrete() {
			System.out.println("Inside Concrete constructor!!");
	}
	
	public void throwExample(int age) throws IOException{
		if(age>16){
			throw new IOException();
		}
		System.out.println("Abc");
	}
}