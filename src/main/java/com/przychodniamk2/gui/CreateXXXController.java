package com.przychodniamk2.gui;

import com.przychodniamk2.business.Address;
import com.przychodniamk2.business.Date;
import com.przychodniamk2.business.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public abstract class CreateXXXController<R> extends FXMLController<R>{
    private String name;
    private String surname;
    private Date dateOfBirth;
    private String peselString;
    private String phoneNumberString;
    private Person.Sex sexSex;
    private String streetName;
    private String buildingString;
    private String flatString = "";
    private String cityName;
    private String zipCodeString = "";
    
    @FXML
    protected TextField firstName;

    @FXML
    protected TextField lastName;

    @FXML
    protected DatePicker birthDate;

    @FXML
    protected TextField pesel;

    @FXML
    protected TextField phoneNumber;
    
    @FXML
    protected ChoiceBox<Person.Sex> sex;

    @FXML
    private TextField street;

    @FXML
    protected TextField building;

    @FXML
    protected TextField flatNumber;

    @FXML
    protected TextField city;

    @FXML
    protected TextField zipCode;

    protected CreateXXXController(String fxml) {
        super(fxml);
    }

    protected void initializeSexAndFormatters(){
        flatNumber.textFormatterProperty().setValue(digitsOnlyFormatter());
        pesel.textFormatterProperty().setValue(digitsOnlyFormatter());

        List<Person.Sex> sexes = new LinkedList<>(Arrays.asList(Person.Sex.values()));
        ObservableList<Person.Sex> observableList = FXCollections.observableArrayList();
        observableList.addAll(sexes);

        firstName.textProperty().addListener(((observable, oldValue, newValue) -> name = newValue));
        lastName.textProperty().addListener(((observable, oldValue, newValue) -> surname = newValue));
        pesel.textProperty().addListener(((observable, oldValue, newValue) -> peselString = newValue));
        phoneNumber.textProperty().addListener(((observable, oldValue, newValue) -> phoneNumberString = newValue));
        street.textProperty().addListener(((observable, oldValue, newValue) -> streetName = newValue));
        building.textProperty().addListener(((observable, oldValue, newValue) -> buildingString = newValue));
        flatNumber.textProperty().addListener(((observable, oldValue, newValue) ->flatString = newValue));
        city.textProperty().addListener(((observable, oldValue, newValue) -> cityName = newValue));
        zipCode.textProperty().addListener(((observable, oldValue, newValue) -> zipCodeString = newValue));

        birthDate.valueProperty().addListener(((observable, oldValue, newValue) -> dateOfBirth = new Date(newValue)));

        birthDate.valueProperty().setValue(LocalDate.now());

        sex.setItems(observableList);

        sex.valueProperty().addListener(((observable, oldValue, newValue) -> sexSex = newValue));

        sex.setValue(Person.Sex.MALE);
    }

    protected Address buildAddress(){
        validateString(streetName, "Ulica");
        validateString(buildingString, "Numer budynku");
        validateString(cityName, "Miasto");
        validateString(zipCodeString, "Kod pocztowy");
        Address address = new Address();
        address.buildingNumber = buildingString;
        address.city = cityName;
        address.street = streetName;
        address.zipCode = zipCodeString;
        address.flatNumber = flatString.equals("") ? 0 : (Short.parseShort(flatString)); //todo change flatNumber type to String
        return address;
    }

    protected Person buildPerson(){
        validateString(name, "Imię");
        validateString(surname, "Nazwisko");
        validateString(peselString, "PESEL");
        Address address = buildAddress();

        Person patient = new Person();
        patient.setPesel(peselString);
        patient.setFirstName(name);
        patient.setLastName(surname);
        patient.setSex(sexSex);
        patient.setAddress(address);
        patient.setDateOfBirth(dateOfBirth);
        patient.setPhoneNumber(phoneNumberString);
        return patient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPeselString() {
        return peselString;
    }

    public void setPeselString(String peselString) {
        this.peselString = peselString;
    }

    public String getPhoneNumberString() {
        return phoneNumberString;
    }

    public void setPhoneNumberString(String phoneNumberString) {
        this.phoneNumberString = phoneNumberString;
    }

    public Person.Sex getSexSex() {
        return sexSex;
    }

    public void setSexSex(Person.Sex sexSex) {
        this.sexSex = sexSex;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getBuildingString() {
        return buildingString;
    }

    public void setBuildingString(String buildingString) {
        this.buildingString = buildingString;
    }

    public String getFlatString() {
        return flatString;
    }

    public void setFlatString(String flatString) {
        this.flatString = flatString;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getZipCodeString() {
        return zipCodeString;
    }

    public void setZipCodeString(String zipCodeString) {
        this.zipCodeString = zipCodeString;
    }
}
