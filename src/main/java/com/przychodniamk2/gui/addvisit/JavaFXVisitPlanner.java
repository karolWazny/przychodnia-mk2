package com.przychodniamk2.gui.addvisit;

import com.przychodniamk2.gui.ModalWindowController;
import com.przychodniamk2.gui.choosedoctor.ChooseDoctorController;
import com.przychodniamk2.systemControl.UserInteractionController;
import com.przychodniamk2.systemControl.usecase.VisitPlanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class JavaFXVisitPlanner implements VisitPlanner {
    @Autowired
    private UserInteractionController userInteractionController;

    @Autowired
    ApplicationContext context;

    @Override
    public void addVisit() {
        ModalWindowController<ChooseDoctorController, String> windowController = new ModalWindowController<>(ChooseDoctorController::new, context);
        windowController.showStage();
        System.out.println(windowController.getData());
    }
}
