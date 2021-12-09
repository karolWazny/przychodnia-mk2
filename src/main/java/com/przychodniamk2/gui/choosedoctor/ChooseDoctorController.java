package com.przychodniamk2.gui.choosedoctor;

import com.przychodniamk2.business.Doctor;
import com.przychodniamk2.gui.FXMLController;
import com.przychodniamk2.systemControl.database.Database;
import com.przychodniamk2.systemControl.UserInteractionController;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Service
public class ChooseDoctorController extends FXMLController<Doctor> {
    private UserInteractionController userInteractionController;

    private Database database;

    private ApplicationContext context;

    private final static String fxml = "/src/main/resources/fxml/chooseDoctor.fxml";

    @FXML
    ListView<Doctor> listView;

    public ChooseDoctorController() {
        super(fxml);
    }

    @FXML
    private void initialize(){
        ReadOnlyObjectProperty<Doctor> ind = listView.getSelectionModel().selectedItemProperty();

        ind.addListener((observable, oldValue, newValue) -> {
            super.data = newValue;
        });
    }

    @FXML
    private void handleChooseButtonAction(ActionEvent event){
        close();
    }

    public ApplicationContext getContext() {
        return context;
    }

    @Override
    public void setContext(ApplicationContext context) {
        this.context = context;
        this.database = context.getBean("database", Database.class);

        List<Doctor> doctors = database.readDoctors();
        ObservableList<Doctor> observableList = FXCollections.observableArrayList();
        observableList.addAll(doctors);
        listView.setItems(observableList);
    }
}
