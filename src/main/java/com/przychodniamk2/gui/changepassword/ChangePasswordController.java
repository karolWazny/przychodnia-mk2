package com.przychodniamk2.gui.changepassword;

import com.przychodniamk2.business.User;
import com.przychodniamk2.gui.FXMLController;
import com.przychodniamk2.systemControl.database.Database;
import com.przychodniamk2.systemControl.usecase.LogInService;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import org.springframework.context.ApplicationContext;

public class ChangePasswordController extends FXMLController<User> {
    private final static String fxml = "changePassword.fxml";
    private User user;
    private SimpleObjectProperty<User> userProperty = new SimpleObjectProperty<>();
    private ApplicationContext context;
    private String oldPass = "";
    private String newPass = "";
    private String repeatNewPass = "";

    @FXML
    private Label loginLabel;

    @FXML
    private Label userLabel;

    @FXML
    private PasswordField oldPassField;

    @FXML
    private PasswordField newPassField;

    @FXML
    private PasswordField repeatPassField;

    public ChangePasswordController() {
        super(fxml);
    }

    @FXML
    private void initialize(){
        oldPassField.textProperty().addListener(((observable, oldValue, newValue) -> oldPass = newValue));
        newPassField.textProperty().addListener(((observable, oldValue, newValue) -> newPass = newValue));
        repeatPassField.textProperty().addListener(((observable, oldValue, newValue) -> repeatNewPass = newValue));
        userProperty.addListener(((observable, oldValue, newValue) -> {
            user = newValue;
            updateLabelsValues();
        }));
    }

    @Override
    public void setContext(ApplicationContext context) {
        this.context = context;
        this.userProperty.set(context.getBean("logInService", LogInService.class).getLoggedUser());
    }

    private void updateLabelsValues(){
        loginLabel.textProperty().set(user.getUsername());
        userLabel.textProperty().set("" + user.getEmployee());
    }

    public void confirm(){
        validateString(oldPass, "Stare hasło");
        validateString(newPass, "Nowe hasło");
        validateString(repeatNewPass, "Powtórz nowe hasło");

        if(!newPass.equals(repeatNewPass))
            throw new RuntimeException("Wprowadzone hasła różnią się między sobą!");

        if(oldPass.equals(newPass))
            throw new RuntimeException("Próba zmiany hasła na identyczne ze starym!");

        String userName = user.getUsername();

        Database database = context.getBean("database", Database.class);

        database.changePassword(userName, oldPass, newPass);
    }

    @FXML
    private void confirmClick(){
        try{
            confirm();

            cleanPasswords();
            close();
        } catch (RuntimeException exception){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd!");
            alert.setHeaderText("Wystąpił błąd.");
            alert.setContentText(exception.getMessage());

            alert.showAndWait();
        }
    }

    @FXML
    private void cancelClick(){
        cleanPasswords();
        close();
    }

    @FXML
    private void cleanPasswords(){
        oldPassField.textProperty().set("");
        newPassField.textProperty().set("");
        repeatPassField.textProperty().set("");
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setOldPass(String oldPass) {
        this.oldPass = oldPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }

    public void setRepeatNewPass(String repeatNewPass) {
        this.repeatNewPass = repeatNewPass;
    }
}
