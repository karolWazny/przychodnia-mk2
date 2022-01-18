package com.przychodniamk2.gui.choosedoctor;

import com.przychodniamk2.unit.business.Doctor;
import com.przychodniamk2.gui.ModalWindowController;
import com.przychodniamk2.systemControl.usecase.DoctorChooser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class JavaFXDoctorChooser implements DoctorChooser {
    private ApplicationContext context;

    @Autowired
    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public Doctor chooseDoctor() {
        ModalWindowController<ChooseDoctorController, Doctor> windowController = new ModalWindowController<>(ChooseDoctorController::new, context);
        windowController.showStage();
        return windowController.getData();
    }
}
