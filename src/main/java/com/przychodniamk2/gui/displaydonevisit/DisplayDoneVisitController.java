package com.przychodniamk2.gui.displaydonevisit;

import com.przychodniamk2.business.DoneVisit;
import com.przychodniamk2.gui.FXMLController;
import org.springframework.context.ApplicationContext;

public class DisplayDoneVisitController extends FXMLController<DoneVisit> {
    private final static String fxml = "displayDoneVisit.fxml";
    protected DisplayDoneVisitController() {
        super(fxml);
    }

    @Override
    public void setContext(ApplicationContext context) {

    }
}
