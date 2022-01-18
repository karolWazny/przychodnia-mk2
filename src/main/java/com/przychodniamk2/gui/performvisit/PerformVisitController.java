package com.przychodniamk2.gui.performvisit;

import com.przychodniamk2.unit.business.DoneVisit;
import com.przychodniamk2.unit.business.ElementOfTreatment;
import com.przychodniamk2.unit.business.ScheduledVisit;
import com.przychodniamk2.gui.FXMLController;
import com.przychodniamk2.systemControl.UserInteractionController;
import com.przychodniamk2.systemControl.database.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.springframework.context.ApplicationContext;

public class PerformVisitController extends FXMLController<ScheduledVisit> {
    private final static String fxml = "performVisit.fxml";

    private UserInteractionController userInteractionController;
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
        try{
            database.createDoneVisit(buildVisit());
            close();
        } catch (RuntimeException exception){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd!");
            alert.setHeaderText("Wystąpił błąd.");
            alert.setContentText("Coś poszło nie tak...");

            alert.showAndWait();
        }
    }

    @FXML
    private void pastVisitsClick(MouseEvent event){
        userInteractionController.browsePastVisits(getData().getPatient());
    }

    private DoneVisit buildVisit(){
        return new DoneVisit.Builder(super.getData())
                .withDescription(description.getText())
                .withIllness(diagnosis.getValue())
                .withProcedure(procedure.getValue())
                .build();
    }

    @FXML
    private void cancelClick(ActionEvent event){
        close();
    }

    @Override
    public void setContext(ApplicationContext context) {
        this.database = context.getBean("database", Database.class);
        userInteractionController = context.getBean("userInteractionController", UserInteractionController.class);
        ObservableList<ElementOfTreatment> observableProcedures = FXCollections.observableList(database.getCurrentProcedures());
        procedure.setItems(observableProcedures);

        ObservableList<ElementOfTreatment> observableDiagnoses = FXCollections.observableList(database.getCurrentDiagnoses());
        diagnosis.setItems(observableDiagnoses);
    }
}
