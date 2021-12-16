package com.przychodniamk2.gui.browsePastVisits;

import com.przychodniamk2.business.DoneVisit;
import com.przychodniamk2.gui.FXMLController;
import org.springframework.context.ApplicationContext;

public class BrowsePastVisitsController extends FXMLController<DoneVisit> {
    private final static String fxml = "browsePastVisits.fxml";

    public BrowsePastVisitsController() {
        super(fxml);
    }

    @Override
    public void setContext(ApplicationContext context) {

    }
}
