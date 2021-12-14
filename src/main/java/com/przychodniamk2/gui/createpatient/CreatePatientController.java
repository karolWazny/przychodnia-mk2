package com.przychodniamk2.gui.createpatient;

import com.przychodniamk2.business.Address;
import com.przychodniamk2.business.Date;
import com.przychodniamk2.business.Doctor;
import com.przychodniamk2.business.Person;
import com.przychodniamk2.gui.FXMLController;
import com.przychodniamk2.systemControl.database.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.springframework.context.ApplicationContext;

import java.util.*;

public class CreatePatientController extends FXMLController<Person> {
    private final static String fxml = "/src/main/resources/fxml/createPatient.fxml";

    private ApplicationContext context;
    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private DatePicker birthDate;

    @FXML
    private TextField pesel;

    @FXML
    private TextField phoneNumber;

    @FXML
    private TextField street;

    @FXML
    private TextField building;

    @FXML
    private TextField flatNumber;

    @FXML
    private TextField city;

    @FXML
    private TextField zipCode;

    @FXML
    private ChoiceBox<Person.Sex> sex;

    public CreatePatientController() {
        super(fxml);
    }

    @Override
    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    @FXML
    private void initialize(){
        flatNumber.textFormatterProperty().setValue(digitsOnlyFormatter());
        pesel.textFormatterProperty().setValue(digitsOnlyFormatter());

        List<Person.Sex> sexes = new LinkedList<>(Arrays.asList(Person.Sex.values()));
        ObservableList<Person.Sex> observableList = FXCollections.observableArrayList();
        observableList.addAll(sexes);

        sex.setItems(observableList);
        sex.setValue(Person.Sex.MALE);
    }

    private TextFormatter<String> digitsOnlyFormatter(){
        return new TextFormatter<>(change -> {
            String newText = change.getText();
            String replacement = newText.replaceAll("[^0-9]*", "");
            change.setText(replacement);
            return change;
        });
    }

    @FXML
    private void confirmClick(ActionEvent event){
        Person patient = buildPatient();
        Database database = context.getBean("database", Database.class);
        database.createPatient(patient);
        super.setData(patient);
        close();
    }

    private Person buildPatient(){
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

    private Address buildAddress(){
        Address address = new Address();
        address.buildingNumber = building.getText();
        address.city = city.getText();
        address.street = street.getText();
        address.zipCode = zipCode.getText();
        address.flatNumber = Short.parseShort(flatNumber.getText());
        return address;
    }

    @FXML
    private void cancelClick(ActionEvent event){
        super.close();
    }
}
