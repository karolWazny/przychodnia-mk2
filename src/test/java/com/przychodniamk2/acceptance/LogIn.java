package com.przychodniamk2.acceptance;

import com.przychodniamk2.gui.login.Credentials;
import com.przychodniamk2.gui.login.LogInServiceImpl;
import com.przychodniamk2.mockups.CredentialsScannerMockupFactory;
import com.przychodniamk2.systemControl.database.Database;
import fit.ColumnFixture;

import java.util.Optional;

public class LogIn extends ColumnFixture {
    private LogInServiceImpl logInService = new LogInServiceImpl();
    private Database mockupDatabase = SetUp.context.getBean("database", Database.class);

    private Credentials credentials = new Credentials("", "");

    private String username;
    private String password;

    public LogIn(){
        super();
        setup();
    }

    private void setup(){
        logInService.setDatabase(mockupDatabase);

        CredentialsScannerMockupFactory credentialsScannerMockupFactory = new CredentialsScannerMockupFactory();
        credentialsScannerMockupFactory.setCredentials(Optional.of(credentials));

        logInService.setFactory(credentialsScannerMockupFactory);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean success(){
        credentials.setPassword(password);
        credentials.setUsername(username);
        return logInService.logIn();
    }

    public String loggedUserName(){
        try{
            return logInService.getLoggedUser().getUsername();
        }catch(NullPointerException e){
            return null;
        }
    }
}
