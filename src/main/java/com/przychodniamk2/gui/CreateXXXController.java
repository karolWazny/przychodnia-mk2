package com.przychodniamk2.gui;

import com.przychodniamk2.unit.business.Address;
import com.przychodniamk2.unit.business.Date;
import com.przychodniamk2.unit.business.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public abstract class CreateXXXController<R> extends FXMLController<R>{
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

        sex.setItems(observableList);
        sex.setValue(Person.Sex.MALE);
    }

    protected Address buildAddress(){
        Address address = new Address();
        address.buildingNumber = building.getText();
        address.city = city.getText();
        address.street = street.getText();
        address.zipCode = zipCode.getText();
        address.flatNumber = Short.parseShort(flatNumber.getText());
        return address;
    }

    protected Person buildPerson(){
        Address address = buildAddress();

        Person patient = new Person();
        patient.setPesel(pesel.getText());
        patient.setFirstName(firstName.getText());
        patient.setLastName(lastName.getText());
        patient.setSex(sex.getValue());
        patient.setAddress(address);
        patient.setDateOfBirth(new Date(birthDate.getValue()));
        patient.setPhoneNumber(phoneNumber.getText());
        return patient;
    }
}
