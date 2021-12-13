package com.przychodniamk2.gui.createpatient;

import com.przychodniamk2.business.Address;
import com.przychodniamk2.business.Person;
import com.przychodniamk2.gui.FXMLController;
import com.przychodniamk2.systemControl.database.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;
import org.springframework.context.ApplicationContext;

import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

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

    public CreatePatientController() {
        super(fxml);
    }

    @Override
    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    @FXML
    private void initialize(){
        flatNumber.textFormatterProperty().setValue(new TextFormatter<String>(change -> {
            String newText = change.getText();
            String replacement = newText.replaceAll("[^0-9]*", "");
            change.setText(replacement);
            return change;
        }));
    }

    @FXML
    private void confirmClick(ActionEvent event){
        Address address = new Address();
        address.buildingNumber = building.getText();
        address.city = city.getText();
        address.street = street.getText();
        address.zipCode = zipCode.getText();
        address.flatNumber = Short.parseShort(flatNumber.getText());

        Person patient = new Person(firstName.getText(),
                                    lastName.getText(),
                                    pesel.getText(),
                                    address);
        Database database = context.getBean("database", Database.class);
        database.createPatient(patient);
        close();
    }

    @FXML
    private void cancelClick(ActionEvent event){
        super.close();
    }
}
