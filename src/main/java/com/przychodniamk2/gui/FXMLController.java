package com.przychodniamk2.gui;

import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class FXMLController<R> {

    private final String fxml;

    private final static String fxmlResourcesPath = "/src/main/resources/fxml/";

    private Stage parent;

    protected FXMLController(String fxml) {
        this.fxml = fxml;
    }

    public URL fxmlLocation(){
        URL output = null;
        try {
            output = new URL("file:///" + System.getProperty("user.dir") + fxmlResourcesPath + fxml);
        } catch (MalformedURLException ignored) {

        }
        return output;
    }

    private R data;

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

    public R getData() {
        return data;
    }

    public void setData(R data) {
        this.data = data;
    }
}
