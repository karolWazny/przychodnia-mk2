package com.przychodniamk2.gui.login;

import com.przychodniamk2.business.User;
import com.przychodniamk2.systemControl.database.Database;
import com.przychodniamk2.systemControl.usecase.LogInService;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LogInServiceImpl implements LogInService {
    private User loggedUser;
    private CredentialsScannerFactory factory;
    private Database database;
    private CredentialsScanner scanner;

    @Override
    public boolean logIn() {
        scanner = factory.credentialsScanner();
        Result result = Result.FAILURE;
        while(result == Result.FAILURE) {
            result = tryLoggingIn();
        }
        return loggedUser != null;
    }

    private Result tryLoggingIn(){
        Optional<Credentials> credentials = scanner.requestCredentials();
        if(credentials.isEmpty()){
            loggedUser = null;
            return Result.CANCEL;
        } else {
            loggedUser = database.logIn(credentials.get().getUsername(), credentials.get().getPassword());
        }
        return loggedUser != null ? Result.SUCCESS : Result.FAILURE;
    }

    @Override
    public User getLoggedUser() {
        return loggedUser;
    }

    @Autowired
    public void setFactory(CredentialsScannerFactory factory) {
        this.factory = factory;
    }

    @Autowired
    public void setDatabase(Database database) {
        this.database = database;
    }
}
