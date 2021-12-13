package com.przychodniamk2.gui.choosedoctor;

import com.przychodniamk2.business.Doctor;
import com.przychodniamk2.gui.ModalWindowController;
import com.przychodniamk2.systemControl.database.Database;
import com.przychodniamk2.systemControl.usecase.DoctorChooser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class JavaFXDoctorChooser implements DoctorChooser {
    @Autowired
    Database database;

    @Autowired
    ApplicationContext context;

    @Override
    public Doctor chooseDoctor() {
        ModalWindowController<ChooseDoctorController, Doctor> windowController = new ModalWindowController<>(ChooseDoctorController::new, context);
        windowController.showStage();
        return windowController.getData();
    }
}
