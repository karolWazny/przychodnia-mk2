package com.przychodniamk2.gui.login;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JavaFXCredentialsScannerFactory implements CredentialsScannerFactory {
    @Override
    public CredentialsScanner credentialsScanner() {
        return new LogInDialog();
    }

    public static class LogInDialog implements CredentialsScanner {
        boolean firstTime = true;

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

        private LogInDialog(){}

        @Override
        public Optional<Credentials> requestCredentials() {
            String text;
            if(firstTime)
                text = "Zaloguj się swoim loginem i hasłem.";
            else
                text = "Nie znaleziono w bazie użytkownika\no takim loginie i haśle!";
            firstTime = false;
            return showLoginDialogWithText(text);
        }
    }
}
