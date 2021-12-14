package com.przychodniamk2.gui.performvisit;

import com.przychodniamk2.business.DoneVisit;
import com.przychodniamk2.business.ElementOfTreatment;
import com.przychodniamk2.business.ScheduledVisit;
import com.przychodniamk2.gui.FXMLController;
import com.przychodniamk2.systemControl.database.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.springframework.context.ApplicationContext;

public class PerformVisitController extends FXMLController<ScheduledVisit> {
    private final static String fxml = "/src/main/resources/fxml/performVisit.fxml";

    private Database database;
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

    @FXML
    TextArea description;

    @FXML
    ChoiceBox<ElementOfTreatment> procedure;

    @FXML
    ChoiceBox<ElementOfTreatment> diagnosis;

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
        database.createDoneVisit(buildVisit());
        close();
    }

    private DoneVisit buildVisit(){
        return new DoneVisit.Builder(super.getData())
                .withDescription(description.getText())
                .withIllness(1)
                .withProcedure(1)
                .build();
    }

    @FXML
    private void cancelClick(ActionEvent event){
        close();
    }

    @Override
    public void setContext(ApplicationContext context) {
        this.database = context.getBean("database", Database.class);
        ObservableList<ElementOfTreatment> observableProcedures = FXCollections.observableList(database.getCurrentProcedures());
        procedure.setItems(observableProcedures);

        ObservableList<ElementOfTreatment> observableDiagnoses = FXCollections.observableList(database.getCurrentDiagnoses());
        diagnosis.setItems(observableDiagnoses);
    }
}
