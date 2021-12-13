package com.przychodniamk2.gui;

import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class FXMLController<R> {

    private final String fxml;

    private Stage parent;

    protected FXMLController(String fxml) {
        this.fxml = fxml;
    }

    public URL fxmlLocation(){
        URL output = null;
        try {
            output = new URL("file:///" + System.getProperty("user.dir") + fxml);
        } catch (MalformedURLException ignored) {

        }
        return output;
    }

    protected R data;

    public Stage getParent(){
        return parent;
    }

    public void setParent(Stage parent){
        this.parent = parent;
    }

    protected void close(){
        if(parent != null){
            parent.close();
        }
    }

    public abstract void setContext(ApplicationContext context);
}
