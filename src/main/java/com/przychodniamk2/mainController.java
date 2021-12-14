package com.przychodniamk2;

import com.przychodniamk2.business.*;
import com.przychodniamk2.systemControl.UserInteractionController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class mainController {
    @Autowired
    private UserInteractionController userInteractionController;

    public mainController(){

    }

    @FXML
    private void choosePatient(ActionEvent event){
        System.out.println("Chosen patient: " + userInteractionController.choosePatient());
    }

    @FXML
    private void chooseDoctor(ActionEvent event) {
        Doctor doctor = userInteractionController.chooseDoctor();
        System.out.println("Chosen doctor: " + doctor);
    }

    @FXML
    private void addDoctor(ActionEvent event){
        Doctor doctor = new Doctor("Jan", "Kowalski", null, new Specialization("ortopeda"), 0);
        userInteractionController.addDoctor(doctor);
        System.out.println("Added doctor: " + doctor);
    }

    @FXML
    private void addVisit(ActionEvent event){
        userInteractionController.addVisit();
    }

    @FXML
    private void chooseVisit(ActionEvent event){
        userInteractionController.chooseVisit();
    }

    @FXML
    private void performVisit(ActionEvent event) {
        ScheduledVisit visit = userInteractionController.chooseVisit();
        userInteractionController.performVisit(visit);
    }

    @FXML
    private void addPatient(ActionEvent event){
        userInteractionController.addPatient();
    }

    @FXML
    private void initialize(ActionEvent event){
    }

    public void setUserInteractionController(UserInteractionController userInteractionController) {
        this.userInteractionController = userInteractionController;
    }
}
