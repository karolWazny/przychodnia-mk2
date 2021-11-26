package com.przychodniamk2;

import com.przychodniamk2.database.User;
import com.przychodniamk2.database.UserRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class mainController {
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

        StringBuilder text = new StringBuilder();
        Iterable<User> users = FrontEnd.context().getBean("userRepository", UserRepository.class).findAll();
        for(User user : users){
            text.append(user.toString());
            text.append('\n');
        }
        stuffOutput.setText(text.toString());
    }

    @FXML
    private void handleSaveButtonAction(ActionEvent event) {
        System.out.println("Wciśnięto przycisk");
    }

    @FXML
    private void initialize(){
    }
}
