package com.przychodniamk2.gui.createuser;

import com.przychodniamk2.business.User;
import com.przychodniamk2.gui.ModalWindowController;
import com.przychodniamk2.systemControl.usecase.UserCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class JavaFXUserCreator implements UserCreator {
    private ApplicationContext context;

    @Override
    public void createNewUser() {
        ModalWindowController<CreateUserController, User> windowController = new ModalWindowController<>(CreateUserController::new, context);
        windowController.showStage();
    }

    @Autowired
    public void setContext(ApplicationContext context) {
        this.context = context;
    }
}
