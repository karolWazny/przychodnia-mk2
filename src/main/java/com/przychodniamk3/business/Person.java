package com.przychodniamk3.business;

public class Person {
	private Address address;
	private String firstName;
	private String lastName;
	private String pesel;

	public Person(Address address, String firstName, String lastName) {
		this.address = address;
		this.firstName = firstName;
		this.lastName = lastName;
	}
}