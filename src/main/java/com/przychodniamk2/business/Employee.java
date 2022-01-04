package com.przychodniamk2.business;

import java.util.Locale;

public class Employee extends Person{
    private final Integer employeeId;
    private final Position position;

    public Employee(String firstName, String lastName, Integer employeeId, String position){
        this(firstName, lastName, employeeId, Position.from(position));
    }

    public Employee(String firstName, String lastName, Integer employeeId, Position position){
        super(firstName, lastName, null);
        this.employeeId = employeeId;
        this.position = position;
    }

    public Employee(String firstName, String lastName, Integer employeeId){
        super(firstName, lastName, null);
        this.employeeId = employeeId;
        this.position = Position.GUEST;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public Position getPosition() {
        return position;
    }

    public enum Position{
        ADMIN,
        DOCTOR,
        REGISTER_LADY,
        GUEST;

        public static Position from(String name){
            switch(name.toUpperCase(Locale.ROOT)){
                case "LEKARZ":
                    return Position.DOCTOR;
                case "ADMINISTRATOR":
                    return Position.ADMIN;
                case "REJESTRATORKA":
                    return Position.REGISTER_LADY;
                case "GOŚĆ":
                    return Position.GUEST;
            }
            return valueOf(name.toUpperCase(Locale.ROOT));
        }
    }

    @Override
    public String toString(){
        return "" + super.toString() + ", " + position;
    }
}
