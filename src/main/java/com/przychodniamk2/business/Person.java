package com.przychodniamk2.business;

public class Person {
	private Address address;
	private String firstName;
	private String lastName;
	private String pesel;
	private Sex sex = Sex.MALE;
	private Date dateOfBirth;
	private String phoneNumber = "";
	private Integer id;

	public Person(Person person){
		this.firstName = person.firstName;
		this.lastName = person.lastName;
		this.pesel = person.pesel;
		this.sex = person.sex;
		this.dateOfBirth = person.dateOfBirth;
		this.phoneNumber = person.phoneNumber;
		this.id = person.id;
		this.address = person.address;
	}

	public Person(){
		this("", "", new Date(), "",new Address());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Person(String firstName, String lastName, Date dateOfBirth, String pesel, Address address) {
		this.address = address;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pesel = pesel;
		this.dateOfBirth = dateOfBirth;
	}

	public Person(String firstName, String lastName, Address address) {
		this(firstName, lastName, new Date(), "", address);
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString(){
		return pesel + " " + firstName + " " + lastName;
	}

	public void setSex(char gender) {
		char code = Character.toLowerCase(gender);
		if(code == Sex.MALE.code){
			this.setSex(Sex.MALE);
			return;
		} else if(code == Sex.FEMALE.code) {
			this.setSex(Sex.FEMALE);
			return;
		}
		throw new IllegalArgumentException();
	}

	public enum Sex{
		MALE('m', "m????czyzna"),
		FEMALE('f', "kobieta");

		public final char code;
		public final String name;

		Sex(char code, String name){
			this.code = code;
			this.name = name;
		}

		@Override
		public String toString(){
			return name;
		}
	}
}