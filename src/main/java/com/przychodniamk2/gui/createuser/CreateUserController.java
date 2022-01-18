package com.przychodniamk2.gui.createuser;

import com.przychodniamk2.unit.business.Employee;
import com.przychodniamk2.unit.business.Person;
import com.przychodniamk2.unit.business.User;
import com.przychodniamk2.gui.CreateXXXController;
import com.przychodniamk2.systemControl.database.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CreateUserController extends CreateXXXController<User> {
    private static final String fxml = "createUser.fxml";
    private Database database;

    @FXML
    private PasswordField passField;

    @FXML
    private PasswordField repeatPassField;

    @FXML
    private TextField loginField;

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
        try{
            if(!passField.textProperty().get().equals(repeatPassField.textProperty().get()))
                throw new RuntimeException("Wprowadzone hasła różnią się!");
            if(loginField.textProperty().get().equals("") || loginField.textProperty().get() == null)
                throw new RuntimeException("Pole login nie może być puste!");

            Person person = buildPerson();

            Employee employee = new Employee(person, function.getValue());

            User user = new User(employee, loginField.textProperty().get());
            database.createUser(user, passField.textProperty().get());

            super.close();
        } catch (RuntimeException exception){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd!");
            alert.setHeaderText("Wystąpił błąd.");
            alert.setContentText(exception.getMessage());

            alert.showAndWait();
        }

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
