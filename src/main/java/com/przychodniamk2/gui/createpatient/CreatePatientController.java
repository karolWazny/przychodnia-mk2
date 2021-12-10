package com.przychodniamk2.gui.createpatient;

import com.przychodniamk2.business.Person;
import com.przychodniamk2.gui.FXMLController;
import org.springframework.context.ApplicationContext;

public class CreatePatientController extends FXMLController<Person> {
    private final static String fxml = "/src/main/resources/fxml/createPatient.fxml";

    public CreatePatientController() {
        super(fxml);
    }

    @Override
    public void setContext(ApplicationContext context) {

    }
}
