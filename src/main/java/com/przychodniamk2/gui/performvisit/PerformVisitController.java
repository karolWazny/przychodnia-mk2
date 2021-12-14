package com.przychodniamk2.gui.performvisit;

import com.przychodniamk2.business.ScheduledVisit;
import com.przychodniamk2.gui.FXMLController;
import org.springframework.context.ApplicationContext;

public class PerformVisitController extends FXMLController<ScheduledVisit> {
    private final static String fxml = "/src/main/resources/fxml/performVisit.fxml";

    public PerformVisitController() {
        super(fxml);
    }

    @Override
    public void setContext(ApplicationContext context) {
    }
}
