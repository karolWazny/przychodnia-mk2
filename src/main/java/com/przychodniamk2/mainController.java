package com.przychodniamk2;

import com.przychodniamk2.business.Person;
import com.przychodniamk2.systemControl.UserInteractionController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class mainController {
    @Autowired
    private UserInteractionController userInteractionController;

    @FXML
    Button saveButton;

    @FXML
    TextArea stuffOutput;

    @FXML Button showButton;

    public mainController(){

    }

    @FXML
    private void handleShowButtonAction(ActionEvent event) {
        System.out.println("Wciśnięto przycisk");

        Person patient = userInteractionController.chooseDoctor();

        System.out.println(patient);
    }

    @FXML
    private void handleSaveButtonAction(ActionEvent event) {
        System.out.println("Wciśnięto przycisk");
    }

    @FXML
    private void initialize(){
    }

    public void setUserInteractionController(UserInteractionController userInteractionController) {
        this.userInteractionController = userInteractionController;
    }
}
