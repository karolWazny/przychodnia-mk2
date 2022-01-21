package com.przychodniamk2.acceptance;

import com.przychodniamk2.business.Employee;
import com.przychodniamk2.business.Person;
import com.przychodniamk2.gui.createuser.CreateUserController;
import fit.ColumnFixture;

public class CreateUser extends ColumnFixture {

    private CreateUserController controller = new CreateUserController();

    private String firstName;
    private String lastName;
    private String pesel;
    private String phoneNumber;
    private String sex;
    private String function;
    private String login;
    private String password;
    private String repeatPassword;
    private String street;
    private String houseNumber;
    private String flatNumber;
    private String city;
    private String zipCode;

    public CreateUser(){
        controller.setContext(SetUp.context);
    }

    public boolean createUser(){
        controller.setName(firstName);
        controller.setSurname(lastName);
        controller.setPeselString(pesel);
        controller.setPhoneNumberString(phoneNumber);
        controller.setLogin(login);
        controller.setPassword(password);
        controller.setRepeatPassword(repeatPassword);
        controller.setStreetName(street);
        controller.setBuildingString(houseNumber);
        controller.setFlatString(flatNumber);
        controller.setCityName(city);
        controller.setZipCodeString(zipCode);
        controller.setSexSex(Person.Sex.valueOf(sex));
        controller.setPosition(Employee.Position.from(function));
        controller.confirm();
        return true;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
