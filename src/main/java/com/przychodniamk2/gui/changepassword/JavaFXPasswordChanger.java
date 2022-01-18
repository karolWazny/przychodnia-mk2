package com.przychodniamk2.gui.changepassword;

import com.przychodniamk2.unit.business.User;
import com.przychodniamk2.gui.ModalWindowController;
import com.przychodniamk2.systemControl.usecase.PasswordChanger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class JavaFXPasswordChanger implements PasswordChanger {
    ApplicationContext context;

    @Override
    public void changePassword() {
        ModalWindowController<ChangePasswordController, User> windowController = new ModalWindowController<>(ChangePasswordController::new, context);
        windowController.showStage();
    }

    @Autowired
    public void setContext(ApplicationContext context) {
        this.context = context;
    }
}
