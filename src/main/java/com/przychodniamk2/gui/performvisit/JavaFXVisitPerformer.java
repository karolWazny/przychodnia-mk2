package com.przychodniamk2.gui.performvisit;

import com.przychodniamk2.unit.business.ScheduledVisit;
import com.przychodniamk2.gui.ModalWindowController;
import com.przychodniamk2.systemControl.usecase.VisitPerformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class JavaFXVisitPerformer implements VisitPerformer {
    private ApplicationContext context;

    @Autowired
    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void performVisit(ScheduledVisit visit) {
        ModalWindowController<PerformVisitController, ScheduledVisit> windowController = new ModalWindowController<>(PerformVisitController::new, context);
        windowController.setData(visit);
        windowController.showStage();
    }
}
