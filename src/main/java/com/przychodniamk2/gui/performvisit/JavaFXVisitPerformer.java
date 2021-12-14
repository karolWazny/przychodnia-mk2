package com.przychodniamk2.gui.performvisit;

import com.przychodniamk2.business.DoneVisit;
import com.przychodniamk2.gui.ModalWindowController;
import com.przychodniamk2.gui.choosepatient.ChoosePatientController;
import com.przychodniamk2.systemControl.usecase.VisitPerformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class JavaFXVisitPerformer implements VisitPerformer {
    @Autowired
    private ApplicationContext context;

    @Override
    public void performVisit() {
        ModalWindowController<PerformVisitController, DoneVisit> windowController = new ModalWindowController<>(PerformVisitController::new, context);
        windowController.showStage();
    }
}
