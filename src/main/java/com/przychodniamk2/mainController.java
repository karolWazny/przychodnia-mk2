package com.przychodniamk2;

import com.przychodniamk2.business.*;
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
    Button choosePatientButton;

    @FXML
    Button chooseDateButton;

    @FXML
    Button chooseDoctorButton;

    @FXML
    Button addDoctorButton;

    @FXML
    Button addVisitButton;

    @FXML
    Button chooseVisitButton;

    @FXML
    Button performVisitButton;

    @FXML
    Button addPatientButton;

    public mainController(){

    }

    @FXML
    private void choosePatient(ActionEvent event){
        System.out.println("Chosen patient: " + userInteractionController.choosePatient());
    }

    @FXML
    private void chooseDate(ActionEvent event){
        System.out.println("Chosen date: " + userInteractionController.chooseDate());
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
        ScheduledVisit visit = new ScheduledVisit();
        userInteractionController.addVisit(visit);
        System.out.println("Added visit: " + visit);
    }

    @FXML
    private void chooseVisit(ActionEvent event){
        System.out.println("Chosen visit: " + userInteractionController.chooseVisit());
    }

    @FXML
    private void performVisit(ActionEvent event) {
        ScheduledVisit visit = userInteractionController.chooseVisit();
        userInteractionController.performVisit(visit);
        System.out.println("Performed visit: " + visit);
    }

    @FXML
    private void addPatient(ActionEvent event){
        Person patient = new Person(new Address(), "Jan", "Kowalski");
        System.out.println("Added patient: " + patient);
    }

    @FXML
    private void initialize(ActionEvent event){
    }

    public void setUserInteractionController(UserInteractionController userInteractionController) {
        this.userInteractionController = userInteractionController;
    }
}
