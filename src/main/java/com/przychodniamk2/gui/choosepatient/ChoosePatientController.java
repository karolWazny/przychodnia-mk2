package com.przychodniamk2.gui.choosepatient;

import com.przychodniamk2.business.Patient;
import com.przychodniamk2.business.Person;
import com.przychodniamk2.gui.FXMLController;
import com.przychodniamk2.systemControl.UserInteractionController;
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

public class ChoosePatientController extends FXMLController<Patient> {
    private ApplicationContext context;
    private Database database;

    @FXML
    private ListView<Patient> patientsListView;

    @FXML
    private TextField peselTextField;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    private final static String fxml = "choosePatient.fxml";

    public ChoosePatientController() {
        super(fxml);
    }

    @FXML
    private void initialize(){
        ReadOnlyObjectProperty<Patient> ind = patientsListView.getSelectionModel().selectedItemProperty();

        ind.addListener((observable, oldValue, newValue) ->
            super.setData(newValue));
    }

    @Override
    public void setContext(ApplicationContext context) {
        this.context = context;

        database = context.getBean("database", Database.class);
        updateListView();
    }

    private void updateListView(){
        Person person = new Person();
        person.setPesel(peselTextField.getText());
        person.setFirstName(firstNameTextField.getText());
        person.setLastName(lastNameTextField.getText());

        List<Patient> patients = database.readPatients(person);
        ObservableList<Patient> observableList = FXCollections.observableArrayList();
        observableList.addAll(patients);
        patientsListView.setItems(observableList);
    }

    @FXML
    private void searchClick(ActionEvent event){
        updateListView();
    }

    @FXML
    private void confirmClick(ActionEvent event){
        close();
    }

    @FXML
    private void cancelClick(ActionEvent event){
        super.setData(null);
        close();
    }

    @FXML
    private void createPatientClick(ActionEvent event){
        UserInteractionController controller = context.getBean("userInteractionController", UserInteractionController.class);
        controller.addPatient();
    }
}
