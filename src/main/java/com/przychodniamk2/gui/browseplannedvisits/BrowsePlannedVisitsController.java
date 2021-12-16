package com.przychodniamk2.gui.browseplannedvisits;

import com.przychodniamk2.business.Date;
import com.przychodniamk2.business.Doctor;
import com.przychodniamk2.business.ScheduledVisit;
import com.przychodniamk2.gui.FXMLController;
import com.przychodniamk2.systemControl.database.Database;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;

public class BrowsePlannedVisitsController extends FXMLController<ScheduledVisit> {
    private final static String fxml = "browsePlannedVisits.fxml";
    public BrowsePlannedVisitsController() {
        super(fxml);
    }
    private Database database;

    private Doctor doctor;
    private Date date = Date.today();

    @FXML
    private ListView<ScheduledVisit> listView;

    @FXML
    private DatePicker datePicker;

    @Override
    public void setContext(ApplicationContext context) {
        database = context.getBean("database", Database.class);
        updateListView();
    }

    @Override
    public void setData(ScheduledVisit scheduledVisit){
        doctor = scheduledVisit.getDoctor();
    }

    @FXML
    private void initialize() {
        datePicker.setValue(LocalDate.now());

        ObjectProperty<LocalDate> dateProperty = datePicker.valueProperty();
        dateProperty.addListener((observable, oldValue, newValue) -> {
            date = new Date(newValue);
            updateListView();
        });

        ReadOnlyObjectProperty<ScheduledVisit> ind = listView.getSelectionModel().selectedItemProperty();

        ind.addListener((observable, oldValue, newValue) ->
                super.setData(newValue));
    }

    private void updateListView(){
        List<ScheduledVisit> visits = database.readPlannedVisits(doctor, date);
        ObservableList<ScheduledVisit> observableList = FXCollections.observableArrayList();
        observableList.addAll(visits);
        listView.setItems(observableList);
    }

    @FXML
    private void cancelClick(MouseEvent event){
        close();
    }

    @FXML
    private void confirmClick(MouseEvent event){
        setData(listView.getSelectionModel().getSelectedItem());
        close();
    }
}
