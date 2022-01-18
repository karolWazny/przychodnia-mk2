package com.przychodniamk2.gui.browsePastVisits;

import com.przychodniamk2.business.Patient;
import com.przychodniamk2.gui.ModalWindowController;
import com.przychodniamk2.systemControl.usecase.PastPatientsVisitBrowser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class JavaFXPastVisitsBrowser implements PastPatientsVisitBrowser {
    private ApplicationContext context;

    @Autowired
    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void browseVisits(Patient patient) {
        ModalWindowController<BrowsePastVisitsController, Patient> windowController = new ModalWindowController<>(BrowsePastVisitsController::new, context);
        windowController.setData(patient);
        windowController.showStage();
    }
}
