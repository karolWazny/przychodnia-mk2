package com.przychodniamk2.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.MalformedURLException;
import java.net.URL;

public class ChooseDoctorController extends FXMLController{
    private final static String fxml = "/src/main/resources/fxml/chooseDoctor.fxml";

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
        super.string = nameTextField.getText();
        ModalWindowController<ChooseDoctorController, Integer> windowController = new ModalWindowController<>(ChooseDoctorController::new);
        windowController.showStage();
        System.out.println(windowController.getData());
    }

    public URL fxmlLocation() {
        URL output = null;
        try {
            output = new URL("file:///" + System.getProperty("user.dir") + fxml);
        } catch (MalformedURLException ignored) {

        }
        return output;
    }
}

