package com.przychodniamk2.acceptance;

import com.przychodniamk2.business.Employee;
import com.przychodniamk2.business.User;
import com.przychodniamk2.gui.login.Credentials;
import com.przychodniamk2.gui.login.LogInServiceImpl;
import com.przychodniamk2.mockups.CredentialsScannerMockupFactory;
import com.przychodniamk2.mockups.MockupDatabase;
import fit.ColumnFixture;

import java.util.Optional;

public class LogIn extends ColumnFixture {
    private LogInServiceImpl logInService = new LogInServiceImpl();
    private MockupDatabase mockupDatabase = new MockupDatabase();
    private int firstNumber;
    private int secondNumber;

    private Credentials credentials = new Credentials("", "");

    private String username;
    private String password;

    public LogIn(){
        super();
        setup();
    }

    private void setup(){
        Employee employee = new Employee("Marek", "Markowski", 0);
        User user = new User (employee, "maro");
        mockupDatabase.createUser(user, "validPassword");

        logInService.setDatabase(mockupDatabase);

        CredentialsScannerMockupFactory credentialsScannerMockupFactory = new CredentialsScannerMockupFactory();
        credentialsScannerMockupFactory.setCredentials(Optional.of(credentials));

        logInService.setFactory(credentialsScannerMockupFactory);
    }

    public int sum(){
        return firstNumber + secondNumber;
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
}
