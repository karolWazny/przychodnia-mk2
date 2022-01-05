package com.przychodniamk2.gui;

import com.przychodniamk2.business.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public abstract class CreateXXXController<R> extends FXMLController<R>{
    @FXML
    protected ChoiceBox<Person.Sex> sex;

    protected CreateXXXController(String fxml) {
        super(fxml);
    }

    protected void initializeItems(){
        List<Person.Sex> sexes = new LinkedList<>(Arrays.asList(Person.Sex.values()));
        ObservableList<Person.Sex> observableList = FXCollections.observableArrayList();
        observableList.addAll(sexes);

        sex.setItems(observableList);
        sex.setValue(Person.Sex.MALE);
    }
}
