package com.przychodniamk2.gui.choosepatient;

import com.przychodniamk2.business.Person;
import com.przychodniamk2.gui.FXMLController;
import com.przychodniamk2.systemControl.database.Database;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ChoosePatientController extends FXMLController<Person> {
    private ApplicationContext context;
    private Database database;

    @FXML
    private ListView<Person> patientsListView;

    @FXML
    private TextField peselTextField;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    private final static String fxml = "/src/main/resources/fxml/choosePatient.fxml";

    public ChoosePatientController() {
        super(fxml);
    }

    @FXML
    private void initialize(){
        ReadOnlyObjectProperty<Person> ind = patientsListView.getSelectionModel().selectedItemProperty();

        ind.addListener((observable, oldValue, newValue) -> {
            super.data = newValue;
        });

        ReadOnlyProperty<String> peselProperty = peselTextField.textProperty();
        peselProperty.addListener((observable, oldValue, newValue) -> {
            Person data = new Person();
            data.setPesel(newValue);
            List<Person> patients = database.readPatients(data);
            ObservableList<Person> observableList = FXCollections.observableArrayList();
            observableList.addAll(patients);
            patientsListView.setItems(observableList);
        });
    }

    @Override
    public void setContext(ApplicationContext context) {
        this.context = context;

        database = context.getBean("database", Database.class);
        List<Person> patients = database.readPatients(new Person());
        ObservableList<Person> observableList = FXCollections.observableArrayList();
        observableList.addAll(patients);
        patientsListView.setItems(observableList);
    }

    @FXML
    private void confirmClick(ActionEvent event){
        close();
    }

    @FXML
    private void cancelClick(ActionEvent event){
        super.data = null;
        close();
    }
}
