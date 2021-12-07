package com.przychodniamk2.gui;

import com.przychodniamk2.systemControl.Database;
import com.przychodniamk2.systemControl.UserInteractionController;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.net.URL;

public class AddVisitController extends FXMLController<String>{
    @Autowired
    private UserInteractionController userInteractionController;

    private Database database;

    private ApplicationContext context;

    private Stage parent;

    @Override
    public URL fxmlLocation() {
        return null;
    }

    @Override
    public Stage getParent() {
        return null;
    }

    @Override
    public void setParent(Stage parent) {

    }

    @Override
    public void setContext(ApplicationContext context) {

    }
}
