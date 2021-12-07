package com.przychodniamk2.gui.addvisit;

import com.przychodniamk2.business.Date;
import com.przychodniamk2.business.Doctor;
import com.przychodniamk2.business.Person;
import com.przychodniamk2.gui.FXMLController;
import com.przychodniamk2.systemControl.Database;
import com.przychodniamk2.systemControl.UserInteractionController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.net.MalformedURLException;
import java.net.URL;

public class AddVisitController extends FXMLController<String> {
    private String fxml = "/src/main/resources/fxml/addVisit.fxml";

    private Person patient;
    private Doctor doctor;
    private Date date;

    @FXML
    Button patientDetailsButton;

    @FXML
    Button choosePatientButton;

    @FXML
    Button chooseDoctorButton;

    @FXML
    Button chooseDateButton;

    @FXML
    Button cancelButton;

    @FXML
    Button confirmButton;

    @Autowired
    private UserInteractionController userInteractionController;

    private Database database;

    private ApplicationContext context;

    private Stage parent;

    @Override
    public URL fxmlLocation() {
        URL output = null;
        try {
            output = new URL("file:///" + System.getProperty("user.dir") + fxml);
        } catch (MalformedURLException ignored) {

        }
        return output;
    }

    @Override
    public Stage getParent() {
        return parent;
    }

    @Override
    public void setParent(Stage parent) {
        this.parent = parent;
    }

    @Override
    public void setContext(ApplicationContext context) {
        this.context = context;
        this.userInteractionController = context.getBean("userInteractionController", UserInteractionController.class);
    }

    @FXML
    private void choosePatientClick(ActionEvent event){
        patient = userInteractionController.choosePatient();

        System.out.println(patient);
    }

    @FXML
    private void chooseDoctorClick(ActionEvent event){
        doctor = userInteractionController.chooseDoctor();
        date = null;
        System.out.println(doctor);
    }

    @FXML
    private void chooseDateClick(ActionEvent event){
        date = userInteractionController.chooseDate(doctor);
        System.out.println(date);
    }
}
