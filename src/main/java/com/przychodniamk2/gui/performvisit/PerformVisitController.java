package com.przychodniamk2.gui.performvisit;

import com.przychodniamk2.business.ScheduledVisit;
import com.przychodniamk2.gui.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.springframework.context.ApplicationContext;

public class PerformVisitController extends FXMLController<ScheduledVisit> {
    private final static String fxml = "/src/main/resources/fxml/performVisit.fxml";

    @FXML
    TextField doctorFirstName;

    @FXML
    TextField doctorLastName;

    @FXML
    TextField doctorSpecialization;

    @FXML
    TextField patientFirstName;

    @FXML
    TextField patientLastName;

    @FXML
    TextField patientPesel;

    public PerformVisitController() {
        super(fxml);
    }

    @FXML
    private void initialize(){
    }

    @Override
    public void setData(ScheduledVisit visit){
        super.setData(visit);
        patientPesel.setText(visit.getPatient().getPesel());
        patientFirstName.setText(visit.getPatient().getFirstName());
        patientLastName.setText(visit.getPatient().getLastName());

        doctorFirstName.setText(visit.getDoctor().getFirstName());
        doctorLastName.setText(visit.getDoctor().getLastName());
        doctorSpecialization.setText(visit.getDoctor().getSpecialization());
    }

    @FXML
    private void confirmClick(ActionEvent event){
        close();
    }

    @FXML
    private void cancelClick(ActionEvent event){
        close();
    }

    @Override
    public void setContext(ApplicationContext context) {

    }
}
