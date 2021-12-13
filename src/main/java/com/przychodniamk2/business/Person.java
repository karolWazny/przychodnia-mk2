package com.przychodniamk2.business;

public class Person {
	private Address address;
	private String firstName;
	private String lastName;
	private String pesel;

	public Person(){
		this("", "", "",new Address());
	}

	public Person(String firstName, String lastName, String pesel, Address address) {
		this.address = address;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pesel = pesel;
	}

	public Person(String firstName, String lastName, Address address) {
		this(firstName, lastName, "", address);
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

	@Override
	public String toString(){
		return pesel + " " + firstName + " " + lastName;
	}
}