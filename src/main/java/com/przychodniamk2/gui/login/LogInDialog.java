package com.przychodniamk2.gui.login;

import com.przychodniamk2.business.Employee;
import com.przychodniamk2.business.User;
import com.przychodniamk2.systemControl.database.Database;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

public class LogInDialog {
    private User loggedUser;
    private Database database;

    public static User logIn(ApplicationContext context){
        LogInDialog dialog = new LogInDialog(context);
        Result result = dialog.tryLoggingInFirstTime();
        while(result == Result.FAILURE){
            result = dialog.tryLoggingInNextTime();
        }
        return dialog.loggedUser;
    }

    private Result tryLoggingInFirstTime(){
        return tryLoggingInWithHeaderText("Zaloguj się swoim loginem i hasłem.");
    }

    private Result tryLoggingInNextTime(){
        return tryLoggingInWithHeaderText("Nie znaleziono w bazie użytkownika\no takim loginie i haśle!");
    }

    private Result tryLoggingInWithHeaderText(String text){
        Optional<Credentials> credentials = showLoginDialogWithText(text);
        if(credentials.isEmpty()){
            loggedUser = null;
            return Result.CANCEL;
        } else {
            loggedUser = database.logIn(credentials.get().username, credentials.get().password);
        }
        return loggedUser != null ? Result.SUCCESS : Result.FAILURE;
    }

    private Optional<Credentials> showLoginDialogWithText(String text){
        // Create the custom dialog.
        Dialog<Credentials> dialog = new Dialog<>();
        dialog.setTitle("Logowanie");
        dialog.setHeaderText(text);

        // Set the button types.
        ButtonType loginButtonType = new ButtonType("Zaloguj", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

        // Create the username and password labels and fields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField username = new TextField();
        username.setPromptText("Login");
        PasswordField password = new PasswordField();
        password.setPromptText("Hasło");

        grid.add(new Label("Login:"), 0, 0);
        grid.add(username, 1, 0);
        grid.add(new Label("Hasło:"), 0, 1);
        grid.add(password, 1, 1);

        // Enable/Disable login button depending on whether a username was entered.
        Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
        loginButton.setDisable(true);

        // Do some validation (using the Java 8 lambda syntax).
        username.textProperty().addListener((observable, oldValue, newValue) ->
            loginButton.setDisable(newValue.trim().isEmpty()));

        dialog.getDialogPane().setContent(grid);

        // Request focus on the username field by default.
        Platform.runLater(username::requestFocus);

        // Convert the result to a username-password-pair when the login button is clicked.
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType) {
                return new Credentials(username.getText(), password.getText());
            }
            return null;
        });

        return dialog.showAndWait();
    }

    private LogInDialog(ApplicationContext context){
        this.database = context.getBean("database", Database.class);
    }

    public static class Credentials{
        private String username;

        private String password;

        public Credentials(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    private enum Result{
        SUCCESS,
        FAILURE,
        CANCEL
    }
}
