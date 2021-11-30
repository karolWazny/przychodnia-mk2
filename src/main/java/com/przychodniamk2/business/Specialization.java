package com.przychodniamk2.business;

public class Specialization {
    private final String name;

    public Specialization(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return name;
    }
}