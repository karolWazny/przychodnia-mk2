package com.przychodniamk2.gui;

import com.przychodniamk2.business.Person;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public abstract class CreateXXXController<R> extends FXMLController<R>{
    @FXML
    protected ChoiceBox<Person.Sex> sex;

    protected CreateXXXController(String fxml) {
        super(fxml);
    }
}
