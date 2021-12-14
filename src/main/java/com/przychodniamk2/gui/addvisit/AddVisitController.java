package com.przychodniamk2.gui.addvisit;

import com.przychodniamk2.business.*;
import com.przychodniamk2.gui.FXMLController;
import com.przychodniamk2.systemControl.UserInteractionController;
import com.przychodniamk2.systemControl.database.Database;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.util.converter.LocalDateStringConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class AddVisitController extends FXMLController<ScheduledVisit> {
    private final static String fxml = "/src/main/resources/fxml/addVisit.fxml";

    private ObjectProperty<Patient> patient;
    private ObjectProperty<Doctor> doctor;
    private ObjectProperty<Date> date;
    private Database database;
    private Time time;

    @FXML
    private TextField doctorFirstName;

    @FXML
    private TextField doctorLastName;

    @FXML
    private TextField doctorSpecialization;

    @FXML
    private TextField patientFirstName;

    @FXML
    private TextField patientLastName;

    @FXML
    private TextField patientPesel;

    @FXML
    private DatePicker datePicker;

    @FXML
    private ComboBox<Time> hourPicker;

    public AddVisitController() {
        super(fxml);
    }

    @FXML
    private void initialize(){
        hourPicker.setPromptText("Wybierz godzinę");
        hourPicker.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(Time item, boolean empty) {
                super.updateItem(item, empty) ;
                if (empty || item == null) {
                    setText("Wybierz godzinę");
                } else {
                    setText(item.toString());
                }
            }
        });

        ReadOnlyProperty<Time> chosenTime = hourPicker.getSelectionModel().selectedItemProperty();
        chosenTime.addListener((observable, oldValue, newValue)->
            time = newValue);

        date = new SimpleObjectProperty<>();
        date.addListener((observable, oldValue, newValue) -> {
            datePicker.setValue(new LocalDateStringConverter().fromString(date.getValue().dateString()));
            List<Time> hours = database.getPossibleAppointmentTimes(doctor.getValue(), newValue);
            ObservableList<Time> observableHours = FXCollections.observableArrayList();
            observableHours.addAll(hours);
            hourPicker.setItems(observableHours);
        });

        doctor = new SimpleObjectProperty<>();
        doctor.addListener((observable, oldValue, newValue) -> {
            doctorFirstName.setText(newValue.getFirstName());
            doctorLastName.setText(newValue.getLastName());
            doctorSpecialization.setText(newValue.getSpecialization());
            date.setValue(database.getFirstPossibleAppointmentDate(newValue));
        });

        patient = new SimpleObjectProperty<>();
        patient.addListener((observable, oldValue, newValue) -> {
            patientFirstName.setText(newValue.getFirstName());
            patientLastName.setText(newValue.getLastName());
            patientPesel.setText(newValue.getPesel());
        });

        System.out.println(datePicker.getValue());
    }

    private UserInteractionController userInteractionController;

    @Override
    public void setContext(ApplicationContext context) {
        this.database = context.getBean("database", Database.class);
        this.userInteractionController = context.getBean("userInteractionController", UserInteractionController.class);
    }

    @FXML
    private void choosePatientClick(ActionEvent event){
        Patient person = userInteractionController.choosePatient();
        if(person != null)
            patient.setValue(person);
    }

    @FXML
    private void chooseDoctorClick(ActionEvent event){
        Doctor doctor = userInteractionController.chooseDoctor();

        if(doctor != null)
            this.doctor.setValue(doctor);
    }

    @FXML
    private void chooseDateClick(ActionEvent event){
        date.setValue(userInteractionController.chooseDate(doctor.getValue()));
        System.out.println(date);
    }

    @FXML
    private void confirmClick(ActionEvent event){
        ScheduledVisit.Builder builder = new ScheduledVisit.Builder()
                .withDoctor(doctor.getValue())
                .withPatient(patient.getValue())
                .day(date.getValue())
                .at(time);
        super.data = builder.build();
        database.createPlannedVisit(super.data);
        close();
    }
}
