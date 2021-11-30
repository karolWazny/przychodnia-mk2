package com.przychodniamk2.gui;

import com.przychodniamk2.business.Doctor;
import com.przychodniamk2.systemControl.Database;
import com.przychodniamk2.systemControl.DoctorChooser;
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
        database.readDoctors(null);
        ModalWindowController<ChooseDoctorController, String> windowController = new ModalWindowController<>(ChooseDoctorController::new, context);
        windowController.showStage();
        System.out.println(windowController.getData());
        return null;
    }
}
