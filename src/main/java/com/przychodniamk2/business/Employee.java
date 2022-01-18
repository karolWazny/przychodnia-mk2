package com.przychodniamk2.business;

import java.util.Locale;

public class Employee extends Person{
    private Integer employeeId;
    private Position position;

    public Employee(Person person, Position position){
        super(person);
        this.position = position;
    }

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

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public enum Position{
        ADMIN("Administrator"),
        DOCTOR("Lekarz"),
        REGISTER_LADY("Rejestratorka"),
        GUEST("Gość");

        public final String name;

        Position(String name){
            this.name = name;
        }

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

        @Override
        public String toString(){
            return name;
        }
    }

    @Override
    public String toString(){
        return "" + super.toString() + ", " + position;
    }
}
