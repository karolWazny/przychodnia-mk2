package com.przychodniamk2.gui.createpatient;

import com.przychodniamk2.business.Person;
import com.przychodniamk2.gui.CreateXXXController;
import com.przychodniamk2.systemControl.database.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import org.springframework.context.ApplicationContext;

public class CreatePatientController extends CreateXXXController<Person> {
    private final static String fxml = "createPatient.fxml";

    private ApplicationContext context;

    public CreatePatientController() {
        super(fxml);
    }

    @Override
    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    @FXML
    private void initialize(){
        initializeSexAndFormatters();
    }

    @FXML
    private void confirmClick(ActionEvent event){
        try{
            Person patient = buildPerson();
            Database database = context.getBean("database", Database.class);
            database.createPatient(patient);
            super.setData(patient);
            close();
        } catch(RuntimeException exception){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd!");
            alert.setHeaderText("Wystąpił błąd.");
            alert.setContentText("Coś poszło nie tak...");

            alert.showAndWait();
        }
    }

    @FXML
    private void cancelClick(ActionEvent event){
        super.close();
    }
}
