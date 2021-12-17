package com.przychodniamk2.gui.displaydonevisit;

import com.przychodniamk2.business.DoneVisit;
import com.przychodniamk2.gui.FXMLController;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.springframework.context.ApplicationContext;

public class DisplayDoneVisitController extends FXMLController<DoneVisit> {
    private final static String fxml = "displayDoneVisit.fxml";
    public DisplayDoneVisitController() {
        super(fxml);
    }

    @FXML
    private TextField docFirstName;
    @FXML
    private TextField docLastName;
    @FXML
    private TextField patientFirstName;
    @FXML
    private TextField patientLastName;
    @FXML
    private TextField diagnosis;
    @FXML
    private TextField procedure;
    @FXML
    private TextField date;
    @FXML
    private TextArea description;

    @Override
    public void setContext(ApplicationContext context) {

    }

    @Override
    public void setData(DoneVisit visit){
        docFirstName.setText(visit.getDoctor().getFirstName());
        docLastName.setText(visit.getDoctor().getLastName());
        patientFirstName.setText(visit.getPatient().getFirstName());
        patientLastName.setText(visit.getPatient().getLastName());
        diagnosis.setText(visit.getIllness().toString());
        procedure.setText(visit.getProcedure().toString());
        date.setText(visit.getDate().toString());
        description.setText(visit.getDescription());
    }
}
