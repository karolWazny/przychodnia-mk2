package com.przychodniamk2.gui.changepassword;

import com.przychodniamk2.business.User;
import com.przychodniamk2.gui.FXMLController;
import org.springframework.context.ApplicationContext;

public class ChangePasswordController extends FXMLController<User> {
    protected ChangePasswordController(String fxml) {
        super(fxml);
    }

    @Override
    public void setContext(ApplicationContext context) {

    }
}
