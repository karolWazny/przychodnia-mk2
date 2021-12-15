package com.przychodniamk2.gui.choosepatient;

import com.przychodniamk2.business.Patient;
import com.przychodniamk2.business.Person;
import com.przychodniamk2.gui.ModalWindowController;
import com.przychodniamk2.systemControl.usecase.PatientChooser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class JavaFXPatientChooser implements PatientChooser {
    ApplicationContext context;

    @Autowired
    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public Patient choosePatient() {
        ModalWindowController<ChoosePatientController, Patient> windowController = new ModalWindowController<>(ChoosePatientController::new, context);
        windowController.showStage();
        return windowController.getData();
    }
}
