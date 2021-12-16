package com.przychodniamk2.gui.displaydonevisit;

import com.przychodniamk2.business.DoneVisit;
import com.przychodniamk2.gui.ModalWindowController;
import com.przychodniamk2.systemControl.usecase.DoneVisitDisplayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class JavaFXDoneVisitDisplayer implements DoneVisitDisplayer {
    private ApplicationContext context;

    @Autowired
    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void display(DoneVisit visit){
        ModalWindowController<DisplayDoneVisitController, DoneVisit> windowController = new ModalWindowController<>(DisplayDoneVisitController::new, context);
        windowController.showStage();
    }
}
