package com.przychodniamk2.gui;

import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;

import java.net.URL;

public abstract class FXMLController<R> {

    public abstract URL fxmlLocation();

    public R data;

    public abstract Stage getParent();
    public abstract void setParent(Stage parent);

    public abstract void setContext(ApplicationContext context);
}
