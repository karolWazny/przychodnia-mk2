package com.przychodniamk2.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ChooseDoctorController {
    @FXML
    Button searchButton;

    @FXML
    TextField nameTextField;

    @FXML
    TextField surnameTextField;

    @FXML
    TextField specializationTextField;

    @FXML
    private void handleSearchButtonAction(ActionEvent event) {
        System.out.println("DEBUG: Wciśnięto przycisk");
    }
}
