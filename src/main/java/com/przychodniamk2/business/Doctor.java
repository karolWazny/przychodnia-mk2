package com.przychodniamk2.business;

public class Doctor extends Employee {
	private Specialization specialization;

	public Doctor(String firstName, String lastName, Address address, Specialization specialization, Integer employeeId) {
		super(firstName, lastName, address, employeeId);
		this.specialization = specialization;
	}

	public Doctor(String firstName, String lastName, Address address, Integer employeeId) {
		this(firstName, lastName, address, null, employeeId);
	}

	@Override
	public String toString(){
		return "" + this.specialization + " " + super.getFirstName() + " " + super.getLastName();
	}

	public String getSpecialization() {
		return "" + specialization;
	}

	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}

}
