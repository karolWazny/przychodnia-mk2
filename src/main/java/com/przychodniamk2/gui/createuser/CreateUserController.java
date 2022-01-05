package com.przychodniamk2.gui.createuser;

import com.przychodniamk2.business.Person;
import com.przychodniamk2.business.User;
import com.przychodniamk2.gui.CreateXXXController;
import com.przychodniamk2.gui.FXMLController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CreateUserController extends CreateXXXController<User> {
    private static final String fxml = "createUser.fxml";

    public CreateUserController() {
        super(fxml);
    }

    @FXML
    private void initialize(){
        List<Person.Sex> sexes = new LinkedList<>(Arrays.asList(Person.Sex.values()));
        ObservableList<Person.Sex> observableList = FXCollections.observableArrayList();
        observableList.addAll(sexes);

        sex.setItems(observableList);
        sex.setValue(Person.Sex.MALE);
    }

    @FXML
    private void confirm(){
        super.close();
    }

    @FXML
    private void cancel(){
        super.close();
    }

    @Override
    public void setContext(ApplicationContext context) {

    }
}
