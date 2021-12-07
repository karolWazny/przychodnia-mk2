package com.przychodniamk2.business;

public class Doctor extends Person {
	private Specialization specialization;

	private final Integer employeeId;

	public Doctor(String firstName, String lastName, Address address, Specialization specialization, Integer employeeId) {
		super(address, firstName, lastName);
		this.specialization = specialization;
		this.employeeId = employeeId;
	}

	public Doctor(String firstName, String lastName, Address address, Integer employeeId) {
		this(firstName, lastName, address, null, employeeId);
	}

	@Override
	public String toString(){
		return "" + this.specialization + " " + super.getFirstName() + " " + super.getLastName();
	}

	public Specialization getSpecialization() {
		return specialization;
	}

	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}
}
