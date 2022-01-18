package com.przychodniamk2.gui.browseplannedvisits;

import com.przychodniamk2.unit.business.Doctor;
import com.przychodniamk2.unit.business.ScheduledVisit;
import com.przychodniamk2.gui.ModalWindowController;
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
        ScheduledVisit scheduledVisit = new ScheduledVisit.Builder().withDoctor(doctor).build();
        windowController.setData(scheduledVisit);
        windowController.showStage();
        return windowController.getData();
    }
}
