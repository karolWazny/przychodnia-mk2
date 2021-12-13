package com.przychodniamk2.gui.createpatient;

import com.przychodniamk2.business.Person;
import com.przychodniamk2.gui.ModalWindowController;
import com.przychodniamk2.systemControl.database.Database;
import com.przychodniamk2.systemControl.usecase.PatientCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class JavaFXPatientCreator implements PatientCreator {
    @Autowired
    private ApplicationContext context;

    @Override
    public void createPatient() {
        ModalWindowController<CreatePatientController, Person> windowController = new ModalWindowController<>(CreatePatientController::new, context);
        windowController.showStage();
        Person newPatient = windowController.getData();
        Database database = context.getBean("database", Database.class);
        database.createPatient(newPatient);
    }
}
