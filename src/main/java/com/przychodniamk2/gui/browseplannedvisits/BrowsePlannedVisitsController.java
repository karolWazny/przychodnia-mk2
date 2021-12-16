package com.przychodniamk2.gui.browseplannedvisits;

import com.przychodniamk2.business.Doctor;
import com.przychodniamk2.business.ScheduledVisit;
import com.przychodniamk2.gui.FXMLController;
import org.springframework.context.ApplicationContext;

public class BrowsePlannedVisitsController extends FXMLController<ScheduledVisit> {
    private final static String fxml = "browsePlannedVisits.fxml";
    public BrowsePlannedVisitsController() {
        super(fxml);
    }
    private Doctor doctor;

    @Override
    public void setContext(ApplicationContext context) {

    }

    @Override
    public void setData(ScheduledVisit scheduledVisit){
        doctor = scheduledVisit.getDoctor();
    }
}
