package com.przychodniamk2.gui.addvisit;

import com.przychodniamk2.business.Date;
import com.przychodniamk2.business.Doctor;
import com.przychodniamk2.business.Person;
import com.przychodniamk2.business.ScheduledVisit;
import com.przychodniamk2.gui.FXMLController;
import com.przychodniamk2.systemControl.UserInteractionController;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class AddVisitController extends FXMLController<ScheduledVisit> {
    private final static String fxml = "/src/main/resources/fxml/addVisit.fxml";

    private Person patient;
    private ObjectProperty<Doctor> doctor;
    private Date date;

    @FXML
    private TextField doctorFirstName;

    @FXML
    private TextField doctorLastName;

    @FXML
    private TextField doctorSpecialization;

    public AddVisitController() {
        super(fxml);
    }

    @FXML
    private void initialize(){
        doctor = new SimpleObjectProperty<Doctor>();
        doctor.addListener((observable, oldValue, newValue) -> {
            doctorFirstName.setText(newValue.getFirstName());
            doctorLastName.setText(newValue.getLastName());
            doctorSpecialization.setText(newValue.getSpecialization());
        });
    }

    @Autowired
    private UserInteractionController userInteractionController;

    @Override
    public void setContext(ApplicationContext context) {
        this.userInteractionController = context.getBean("userInteractionController", UserInteractionController.class);
    }

    @FXML
    private void choosePatientClick(ActionEvent event){
        patient = userInteractionController.choosePatient();

        System.out.println(patient);
    }

    @FXML
    private void chooseDoctorClick(ActionEvent event){
        doctor.setValue(userInteractionController.chooseDoctor());

        date = null;
    }

    @FXML
    private void chooseDateClick(ActionEvent event){
        date = userInteractionController.chooseDate(doctor.getValue());
        System.out.println(date);
    }

    @FXML
    private void confirmClick(ActionEvent event){
        super.data = new ScheduledVisit();
        close();
    }
}
