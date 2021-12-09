package com.przychodniamk2.gui.choosepatient;

import com.przychodniamk2.business.Person;
import com.przychodniamk2.gui.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.springframework.context.ApplicationContext;

public class ChoosePatientController extends FXMLController<Person> {
    private ApplicationContext context;

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
    private void initialize(){}

    @Override
    public void setContext(ApplicationContext context) {
        this.context = context;
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
