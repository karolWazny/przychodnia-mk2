package com.przychodniamk2.gui.addvisit;

import com.przychodniamk2.business.Date;
import com.przychodniamk2.business.Doctor;
import com.przychodniamk2.business.Person;
import com.przychodniamk2.business.ScheduledVisit;
import com.przychodniamk2.gui.FXMLController;
import com.przychodniamk2.systemControl.UserInteractionController;
import com.przychodniamk2.systemControl.database.Database;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.util.converter.LocalDateStringConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

public class AddVisitController extends FXMLController<ScheduledVisit> {
    private final static String fxml = "/src/main/resources/fxml/addVisit.fxml";

    private ObjectProperty<Person> patient;
    private ObjectProperty<Doctor> doctor;
    private ObjectProperty<Date> date;
    private Database database;

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
    private ComboBox<Integer> hourPicker;

    public AddVisitController() {
        super(fxml);
    }

    @FXML
    private void initialize(){
        date = new SimpleObjectProperty<>();
        date.addListener((observable, oldValue, newValue) -> {
            System.out.println(new LocalDateStringConverter().toString(LocalDate.of(1970, 11, 11)));
            datePicker.setValue(new LocalDateStringConverter().fromString(date.getValue().dateString()));
        });

        doctor = new SimpleObjectProperty<Doctor>();
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

    @Autowired
    private UserInteractionController userInteractionController;

    @Override
    public void setContext(ApplicationContext context) {
        this.database = context.getBean("database", Database.class);
        this.userInteractionController = context.getBean("userInteractionController", UserInteractionController.class);
    }

    @FXML
    private void choosePatientClick(ActionEvent event){
        Person person = userInteractionController.choosePatient();
        if(person != null)
            patient.setValue(person);

        System.out.println(patient);
    }

    @FXML
    private void chooseDoctorClick(ActionEvent event){
        Doctor doctor = userInteractionController.chooseDoctor();

        if(doctor != null)
            this.doctor.setValue(doctor);

        date = null;
    }

    @FXML
    private void chooseDateClick(ActionEvent event){
        date.setValue(userInteractionController.chooseDate(doctor.getValue()));
        System.out.println(date);
    }

    @FXML
    private void confirmClick(ActionEvent event){
        super.data = new ScheduledVisit();
        close();
    }
}
