package com.przychodniamk2.gui.changepassword;

import com.przychodniamk2.systemControl.usecase.PasswordChanger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class JavaFXPasswordChanger implements PasswordChanger {
    ApplicationContext context;

    @Override
    public void changePassword() {
    }

    @Autowired
    public void setContext(ApplicationContext context) {
        this.context = context;
    }
}
