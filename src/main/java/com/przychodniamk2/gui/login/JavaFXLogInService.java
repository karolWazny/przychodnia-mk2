package com.przychodniamk2.gui.login;

import com.przychodniamk2.unit.business.User;
import com.przychodniamk2.systemControl.usecase.LogInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class JavaFXLogInService implements LogInService {
    private ApplicationContext context;
    private User loggedUser;

    @Override
    public boolean logIn() {
        loggedUser = LogInDialog.logIn(context);
        return loggedUser != null;
    }

    @Override
    public User getLoggedUser() {
        return loggedUser;
    }

    @Autowired
    public void setContext(ApplicationContext context) {
        this.context = context;
    }
}
