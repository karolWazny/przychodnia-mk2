package com.przychodniamk2.gui.browseplannedvisits;

import com.przychodniamk2.business.ScheduledVisit;
import com.przychodniamk2.gui.FXMLController;
import org.springframework.context.ApplicationContext;

public class BrowsePlannedVisitsController extends FXMLController<ScheduledVisit> {
    private final static String fxml = "browsePlannedVisits.fxml";
    public BrowsePlannedVisitsController() {
        super(fxml);
    }

    @Override
    public void setContext(ApplicationContext context) {

    }
}
