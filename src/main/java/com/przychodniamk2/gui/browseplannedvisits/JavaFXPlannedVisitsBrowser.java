package com.przychodniamk2.gui.browseplannedvisits;

import com.przychodniamk2.business.Doctor;
import com.przychodniamk2.business.ScheduledVisit;
import com.przychodniamk2.gui.ModalWindowController;
import com.przychodniamk2.gui.choosedoctor.ChooseDoctorController;
import com.przychodniamk2.systemControl.usecase.DoctorPlannedVisitBrowser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class JavaFXPlannedVisitsBrowser implements DoctorPlannedVisitBrowser {
    private ApplicationContext context;

    @Autowired
    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public ScheduledVisit browseVisits(Doctor doctor) {
        ModalWindowController<BrowsePlannedVisitsController, ScheduledVisit> windowController = new ModalWindowController<>(BrowsePlannedVisitsController::new, context);
        windowController.showStage();
        return windowController.getData();
    }
}
