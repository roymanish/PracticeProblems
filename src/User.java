
import java.io.Serializable;
import java.util.Date;
import java.util.Map;
 
class PrimeUser implements Serializable{
	
	private String ethinicity;
	
	public PrimeUser(String ethinicity) {
		this.ethinicity = ethinicity;
	}

	/**
	 * @return the ethinicity
	 */
	public String getEthinicity() {
		return ethinicity;
	}

	/**
	 * @param ethinicity the ethinicity to set
	 */
	public void setEthinicity(String ethinicity) {
		this.ethinicity = ethinicity;
	}
	
	
}


class Person implements Serializable{
	
	private String language;

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	
	
}
public class User extends Person implements Serializable {
 
    private static final long serialVersionUID = 7829136421241571165L;
     
    private String firstName;
    private String lastName;
    private int accountNumber;
    private Date dateOpened;
    
    private Map<String, String> props;
    
    private PrimeUser prime;
 
    public User(String firstName, String lastName, int accountNumber, Date dateOpened) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.dateOpened = dateOpened;
    }
     
    public User() {
        super();
    }
 
   
 
    /**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the accountNumber
	 */
	public int getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the dateOpened
	 */
	public Date getDateOpened() {
		return dateOpened;
	}

	/**
	 * @param dateOpened the dateOpened to set
	 */
	public void setDateOpened(Date dateOpened) {
		this.dateOpened = dateOpened;
	}

	/**
	 * @return the props
	 */
	public Map<String, String> getProps() {
		return props;
	}

	/**
	 * @param props the props to set
	 */
	public void setProps(Map<String, String> props) {
		this.props = props;
	}

	/**
	 * @return the prime
	 */
	public PrimeUser getPrime() {
		return prime;
	}

	/**
	 * @param prime the prime to set
	 */
	public void setPrime(PrimeUser prime) {
		this.prime = prime;
	}

	
	/*private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException
    {      
        firstName = aInputStream.readUTF();
        firstName = "Manish Roy";
        lastName = aInputStream.readUTF();
        accountNumber = aInputStream.readInt();
        dateOpened = new Date(aInputStream.readLong());
    }*/
 
    /*private void writeObject(ObjectOutputStream aOutputStream) throws IOException
    {
    	System.out.println(this.getFirstName());
        System.out.println(this.getLastName());
        System.out.println(this.getAccountNumber());
        System.out.println(this.getDateOpened());
        
        aOutputStream.writeUTF(firstName);
        aOutputStream.writeUTF(lastName);
        aOutputStream.writeInt(accountNumber);
        aOutputStream.writeLong(dateOpened.getTime());
    }*/
}