package com.przychodniamk2.acceptance;

import fit.ColumnFixture;

public class CreateUser extends ColumnFixture {
    private int firstNumber;
    private int secondNumber;

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public int sum(){
        return firstNumber + secondNumber;
    }
}
