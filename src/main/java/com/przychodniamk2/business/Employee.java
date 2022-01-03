package com.przychodniamk2.business;

public class Employee extends Person{
    private final Integer employeeId;

    public Employee(String firstName, String lastName, Address address, Integer employeeId){
        super(firstName, lastName, address);
        this.employeeId = employeeId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }
}
