package com.przychodniamk2.gui.createpatient;

import com.przychodniamk2.business.Address;
import com.przychodniamk2.business.Date;
import com.przychodniamk2.business.Person;
import com.przychodniamk2.gui.CreateXXXController;
import com.przychodniamk2.systemControl.database.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
        Person patient = buildPerson();
        Database database = context.getBean("database", Database.class);
        database.createPatient(patient);
        super.setData(patient);
        close();
    }

    @FXML
    private void cancelClick(ActionEvent event){
        super.close();
    }
}
