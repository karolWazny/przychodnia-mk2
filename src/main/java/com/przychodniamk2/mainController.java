package com.przychodniamk2;

import com.przychodniamk2.business.*;
import com.przychodniamk2.systemControl.UserInteractionController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class mainController {
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
        Doctor doctor = userInteractionController.chooseDoctor();
        System.out.println(userInteractionController.browseDoctorsPlannedVisits(doctor));
    }

    @FXML
    private void performVisit(ActionEvent event) {
        ScheduledVisit visit = new ScheduledVisit(new Doctor("Bob", "Ross", new Address(), new Specialization("ortopeda"), 1),
                new Patient(),
                new Date(),
                new Time(), 2);
        userInteractionController.performVisit(visit);
    }

    @FXML
    private void addPatient(ActionEvent event){
        userInteractionController.addPatient();
    }

    @FXML
    private void initialize(ActionEvent event){
    }

    @FXML
    private void browsePastVisitsClick(ActionEvent event){
        Patient patient = userInteractionController.choosePatient();
        userInteractionController.browsePastVisits(patient);
    }

    @Autowired
    public void setUserInteractionController(UserInteractionController userInteractionController) {
        this.userInteractionController = userInteractionController;
    }
}
