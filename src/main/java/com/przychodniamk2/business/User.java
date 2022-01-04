package com.przychodniamk2.business;

public class User {
    private final Employee employee;
    private final String username;

    public User(Employee employee, String username) {
        this.employee = employee;
        this.username = username;
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getUsername() {
        return username;
    }
}
