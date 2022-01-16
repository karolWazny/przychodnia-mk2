package com.przychodniamk2;

import com.przychodniamk2.business.*;
import com.przychodniamk2.systemControl.UserInteractionController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import org.springframework.stereotype.Service;

@Service
public class MainController {
    private UserInteractionController userInteractionController;

    @FXML
    private Label userName;

    @FXML
    private Pane registerActions;

    @FXML
    private Pane doctorActions;

    @FXML
    private Pane administrativeActions;

    public MainController(){

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
        Doctor doctor = userInteractionController.chooseDoctor();
        ScheduledVisit visit = userInteractionController.browseDoctorsPlannedVisits(doctor);
        userInteractionController.performVisit(visit);
    }

    @FXML
    private void addPatient(ActionEvent event){
        userInteractionController.addPatient();
    }

    @FXML
    private void initialize(){
        administrativeActions.setDisable(true);
        administrativeActions.setVisible(false);
        doctorActions.setDisable(true);
        doctorActions.setVisible(false);
        registerActions.setDisable(true);
        registerActions.setVisible(false);
    }

    @FXML
    private void browsePastVisitsClick(ActionEvent event){
        Patient patient = userInteractionController.choosePatient();
        userInteractionController.browsePastVisits(patient);
    }

    @FXML
    private void createUser(ActionEvent event){
        userInteractionController.createNewUser();
    }

    @FXML
    private void changePasswordClick(ActionEvent event){
        userInteractionController.changePassword();
    }

    public void setUserInteractionController(UserInteractionController userInteractionController) {
        this.userInteractionController = userInteractionController;
        Employee.Position position = userInteractionController.getLoggedUser().getEmployee().getPosition();
        switch(position){
            case REGISTER_LADY:
                registerActions.setDisable(false);
                registerActions.setVisible(true);
                break;
            case DOCTOR:
                doctorActions.setDisable(false);
                doctorActions.setVisible(true);
                break;
            case ADMIN:
                administrativeActions.setDisable(false);
                administrativeActions.setVisible(true);

                doctorActions.setDisable(false);
                doctorActions.setVisible(true);

                registerActions.setDisable(false);
                registerActions.setVisible(true);
                break;
            default:
                break;
        }
        userName.textProperty().set("" + userInteractionController.getLoggedUser());
    }
}
