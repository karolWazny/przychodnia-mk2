package com.przychodniamk2.gui.createuser;

import com.przychodniamk2.business.User;
import com.przychodniamk2.gui.FXMLController;
import javafx.fxml.FXML;
import org.springframework.context.ApplicationContext;

public class CreateUserController extends FXMLController<User> {
    private static final String fxml = "createUser.fxml";

    public CreateUserController() {
        super(fxml);
    }

    @FXML
    private void confirm(){
        super.close();
    }

    @FXML
    private void cancel(){
        super.close();
    }

    @Override
    public void setContext(ApplicationContext context) {

    }
}
