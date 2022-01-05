package com.przychodniamk2.gui.createuser;

import com.przychodniamk2.business.Employee;
import com.przychodniamk2.business.User;
import com.przychodniamk2.gui.CreateXXXController;
import com.przychodniamk2.systemControl.database.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CreateUserController extends CreateXXXController<User> {
    private static final String fxml = "createUser.fxml";
    private Database database;

    @FXML
    private ComboBox<String> specialization;

    @FXML
    private ChoiceBox<Employee.Position> function;

    public CreateUserController() {
        super(fxml);
    }

    @FXML
    private void initialize(){
        initializeSexAndFormatters();

        initializeFunctionChoiceBox();
    }

    private void initializeFunctionChoiceBox(){
        List<Employee.Position> positions = new LinkedList<>(Arrays.asList(Employee.Position.values()));
        ObservableList<Employee.Position> observableList = FXCollections.observableArrayList();
        observableList.addAll(positions);

        function.setItems(observableList);
        function.setValue(Employee.Position.GUEST);
    }

    @FXML
    private void confirm(){
        super.close();
    }

    @FXML
    private void cancel(){
        super.close();
    }

    @Override
    public void setContext(ApplicationContext context) {
        this.database = context.getBean("database", Database.class);
    }
}
