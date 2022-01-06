package com.przychodniamk2.gui.changepassword;

import com.przychodniamk2.business.User;
import com.przychodniamk2.gui.FXMLController;
import com.przychodniamk2.systemControl.usecase.LogInService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.springframework.context.ApplicationContext;

public class ChangePasswordController extends FXMLController<User> {
    private final static String fxml = "changePassword.fxml";
    private User user;
    private ApplicationContext context;

    @FXML
    private Label loginLabel;

    @FXML
    private Label userLabel;

    public ChangePasswordController() {
        super(fxml);
    }

    @Override
    public void setContext(ApplicationContext context) {
        this.context = context;
        this.user = context.getBean("logInService", LogInService.class).getLoggedUser();

        initializeLabels();
    }

    private void initializeLabels(){
        loginLabel.textProperty().set(user.getUsername());
        userLabel.textProperty().set("" + user.getEmployee());
    }

    @FXML
    private void confirmClick(){
        close();
    }

    @FXML
    private void cancelClick(){
        close();
    }
}
