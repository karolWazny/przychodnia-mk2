package com.przychodniamk2.unit.business;

public class Patient extends Person{
    private Integer patientId;

    public Patient(){}

    public Patient(String firstName, String lastName, Date birthDate, String pesel, Address address) {
        super();
        setAddress(address);
        setFirstName(firstName);
        setLastName(lastName);
        setDateOfBirth(birthDate);
        setPesel(pesel);
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }
}
