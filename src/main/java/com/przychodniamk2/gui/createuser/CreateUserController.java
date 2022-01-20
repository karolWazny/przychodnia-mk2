package com.przychodniamk2.gui.createuser;

import com.przychodniamk2.business.Employee;
import com.przychodniamk2.business.Person;
import com.przychodniamk2.business.User;
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

    private String login = "";
    private String password = "";
    private String repeatPassword = "";

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
        passField.textProperty().addListener(((observable, oldValue, newValue) -> password = newValue));
        repeatPassField.textProperty().addListener(((observable, oldValue, newValue) -> repeatPassword = newValue));
        loginField.textProperty().addListener(((observable, oldValue, newValue) -> login = newValue));

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
            if(!password.equals(repeatPassword))
                throw new RuntimeException("Wprowadzone hasła różnią się!");
            if(login.equals(""))
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}
