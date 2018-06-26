/**
 * 
 */
package com.maroy.designpattern;


/**
 * @author MaRoy
 *
 */
public class BuilderPatternDemo {

	public static void main(String[] args) {

		User usr = new User.UserBuilder().firstName("Armaan").lastName("Kapoor").age(35).city("Mumbai").build();
		System.out.println(usr.toString());
	}
}

class User{

	private String firstName;
	private String lastName;
	private int age;
	private String weight;
	private String phoneNumber;
	private String city;
	private String occupation;
	private String nationality;

	private User(UserBuilder builder){

		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.age = builder.age;
		this.weight = builder.weight;
		this.phoneNumber = builder.phoneNumber;
		this.city = builder.city;
		this.occupation = builder.occupation;
		this.nationality = builder.nationality;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Override
	public String toString() {
		return this.firstName+" "+this.lastName+" of age "+this.age+" lives in "+this.city;
	}

	static class UserBuilder{

		private String firstName;
		private String lastName;
		private int age;
		private String weight;
		private String phoneNumber;
		private String city;
		private String occupation;
		private String nationality;

		public UserBuilder firstName(String firstName){
			this.firstName = firstName;
			return this;
		}

		public UserBuilder lastName(String lastName){
			this.lastName = lastName;
			return this;
		}

		public UserBuilder age(int age){
			this.age = age;
			return this;
		}

		public UserBuilder weight(String weight){
			this.weight = weight;
			return this;
		}

		public UserBuilder phoneNumber(String phoneNumber){
			this.phoneNumber = phoneNumber;
			return this;
		}

		public UserBuilder city(String city){
			this.city = city;
			return this;
		}

		public UserBuilder occupation(String occupation){
			this.occupation = occupation;
			return this;
		}

		public UserBuilder nationality(String nationality){
			this.nationality = nationality;
			return this;
		}

		public User build(){
			return new User(this);
		}
	}
}
