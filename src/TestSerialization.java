import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestSerialization {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		TestInnerClass test = new TestInnerClass();
		File file = new File("test");
        new ObjectOutputStream(new FileOutputStream(file)).writeObject(test);
        
        TestInnerClass test1 = (TestInnerClass)new ObjectInputStream(new FileInputStream(file)).readObject();
        
        System.out.println(test1);
	}

}

class TestInnerClass implements Serializable{

	private InnerClass inner = new InnerClass();
	
    public void serializeInnerClass() throws IOException {
        
    }

    private class InnerClass implements Serializable {

        private static final long serialVersionUID = 1L;

    }

}