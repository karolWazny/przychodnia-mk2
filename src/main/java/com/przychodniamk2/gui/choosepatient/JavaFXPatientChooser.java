package com.przychodniamk2.gui.choosepatient;

import com.przychodniamk2.business.Doctor;
import com.przychodniamk2.business.Person;
import com.przychodniamk2.gui.ModalWindowController;
import com.przychodniamk2.gui.choosedoctor.ChooseDoctorController;
import com.przychodniamk2.systemControl.usecase.PatientChooser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class JavaFXPatientChooser implements PatientChooser {
    @Autowired
    ApplicationContext context;

    @Override
    public Person choosePatient() {
        ModalWindowController<ChoosePatientController, Person> windowController = new ModalWindowController<>(ChoosePatientController::new, context);
        windowController.showStage();
        return windowController.getData();
    }
}
