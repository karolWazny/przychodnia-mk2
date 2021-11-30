package com.przychodniamk2.gui;

import com.przychodniamk2.business.Doctor;
import com.przychodniamk2.systemControl.Database;
import com.przychodniamk2.systemControl.UserInteractionController;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Service
public class ChooseDoctorController extends FXMLController<String> {
    @Autowired
    private UserInteractionController userInteractionController;

    private Database database;

    private ApplicationContext context;

    private Stage parent;

    private final static String fxml = "/src/main/resources/fxml/chooseDoctor.fxml";

    @FXML
    Button searchButton;

    @FXML
    TextField nameTextField;

    @FXML
    TextField surnameTextField;

    @FXML
    TextField specializationTextField;

    @FXML
    ListView<Doctor> listView;

    @FXML
    private void initialize(){

    }

    @FXML
    private void handleSearchButtonAction(ActionEvent event) {
        System.out.println("DEBUG: Wciśnięto przycisk");
    }

    @FXML
    private void handleChooseButtonAction(ActionEvent event){
        super.string = nameTextField.getText();
        if(parent != null){
            parent.close();
        }
    }

    public URL fxmlLocation() {
        URL output = null;
        try {
            output = new URL("file:///" + System.getProperty("user.dir") + fxml);
        } catch (MalformedURLException ignored) {

        }
        return output;
    }

    public Stage getParent() {
        return parent;
    }

    public void setParent(Stage parent) {
        this.parent = parent;
    }

    public ApplicationContext getContext() {
        return context;
    }

    @Override
    public void setContext(ApplicationContext context) {
        this.context = context;
        this.database = context.getBean("database", Database.class);

        List<Doctor> doctors = database.readDoctors(null);
        ObservableList<Doctor> observableList = FXCollections.observableArrayList();
        observableList.addAll(doctors);
        listView.setItems(observableList);
    }
}
