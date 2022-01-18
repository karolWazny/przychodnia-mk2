package com.przychodniamk2.gui.changepassword;

import com.przychodniamk2.unit.business.User;
import com.przychodniamk2.gui.FXMLController;
import com.przychodniamk2.systemControl.database.Database;
import com.przychodniamk2.systemControl.usecase.LogInService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import org.springframework.context.ApplicationContext;

public class ChangePasswordController extends FXMLController<User> {
    private final static String fxml = "changePassword.fxml";
    private User user;
    private ApplicationContext context;

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

    @Override
    public void setContext(ApplicationContext context) {
        this.context = context;
        this.user = context.getBean("logInService", LogInService.class).getLoggedUser();

        initializeLabels();
    }

    private void initializeLabels(){
        loginLabel.textProperty().set(user.getUsername());
        userLabel.textProperty().set("" + user.getEmployee());
    }

    @FXML
    private void confirmClick(){
        try{
            if(!newPassField.textProperty().get().equals(repeatPassField.textProperty().get()))
                throw new RuntimeException("Wprowadzone hasła różnią się między sobą!");

            if(oldPassField.textProperty().get().equals(repeatPassField.textProperty().get()))
                throw new RuntimeException("Próba zmiany hasła na identyczne ze starym!");

            String userName = user.getUsername();
            String oldPassword = oldPassField.textProperty().get();
            String newPassword = newPassField.textProperty().get();

            Database database = context.getBean("database", Database.class);

            database.changePassword(userName, oldPassword, newPassword);

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
        close();
    }
}
