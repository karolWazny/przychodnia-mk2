package com.przychodniamk2.gui.createuser;

import com.przychodniamk2.business.User;
import com.przychodniamk2.gui.FXMLController;
import org.springframework.context.ApplicationContext;

public class CreateUserController extends FXMLController<User> {
    private static final String fxml = "createUser.fxml";

    protected CreateUserController() {
        super(fxml);
    }

    @Override
    public void setContext(ApplicationContext context) {

    }
}
