package com.przychodniamk2.gui.addvisit;

import com.przychodniamk2.unit.business.ScheduledVisit;
import com.przychodniamk2.gui.ModalWindowController;
import com.przychodniamk2.systemControl.usecase.VisitPlanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class JavaFXVisitPlanner implements VisitPlanner {
    ApplicationContext context;

    @Autowired
    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void addVisit() {
        ModalWindowController<AddVisitController, ScheduledVisit> windowController = new ModalWindowController<>(AddVisitController::new, context);
        windowController.showStage();
    }
}
