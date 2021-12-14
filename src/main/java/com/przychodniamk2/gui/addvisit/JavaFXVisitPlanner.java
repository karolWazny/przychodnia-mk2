package com.przychodniamk2.gui.addvisit;

import com.przychodniamk2.business.ScheduledVisit;
import com.przychodniamk2.gui.ModalWindowController;
import com.przychodniamk2.systemControl.database.Database;
import com.przychodniamk2.systemControl.UserInteractionController;
import com.przychodniamk2.systemControl.usecase.VisitPlanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class JavaFXVisitPlanner implements VisitPlanner {
    @Autowired
    ApplicationContext context;

    @Override
    public void addVisit() {
        ModalWindowController<AddVisitController, ScheduledVisit> windowController = new ModalWindowController<>(AddVisitController::new, context);
        windowController.showStage();
    }
}
