package com.przychodniamk2.gui.choosepatient;

import com.przychodniamk2.business.Person;
import com.przychodniamk2.gui.FXMLController;
import com.przychodniamk2.systemControl.UserInteractionController;
import org.springframework.context.ApplicationContext;

public class ChoosePatientController extends FXMLController<Person> {
    private UserInteractionController userInteractionController;

    private ApplicationContext context;

    private final static String fxml = "/src/main/resources/fxml/choosePatient.fxml";

    public ChoosePatientController() {
        super(fxml);
    }

    @Override
    public void setContext(ApplicationContext context) {
        this.context = context;
    }
}
