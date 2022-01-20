package com.przychodniamk2.acceptance;

import com.przychodniamk2.business.Employee;
import com.przychodniamk2.business.User;
import com.przychodniamk2.gui.changepassword.ChangePasswordController;
import com.przychodniamk2.mockups.MockupContextImpl;
import com.przychodniamk2.mockups.MockupDatabase;
import fit.ColumnFixture;

public class ChangePassword extends ColumnFixture {
    private ChangePasswordController controller = new ChangePasswordController();

    private boolean userLoggedIn;
    private String newPass;
    private String repeatNewPass;
    private String oldPass;
    private MockupDatabase mockupDatabase = new MockupDatabase();
    private User user;

    public ChangePassword(){
        super();
        setup();
    }

    private void setup(){
        Employee employee = new Employee("Marek", "Markowski", 0);
        user = new User (employee, "maro");
        mockupDatabase.createUser(user, "validPassword");

        MockupContextImpl context = new MockupContextImpl();
        context.setDatabase(mockupDatabase);

        controller.setContext(context);
    }

    public void setUserLoggedIn(boolean userLoggedIn) {
        this.userLoggedIn = userLoggedIn;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }

    public void setRepeatNewPass(String repeatNewPass) {
        this.repeatNewPass = repeatNewPass;
    }

    public void setOldPass(String oldPass) {
        this.oldPass = oldPass;
    }

    public boolean changePassword(){
        controller.setUser(userLoggedIn ? user : null);

        controller.setNewPass(newPass);
        controller.setOldPass(oldPass);
        controller.setRepeatNewPass(repeatNewPass);
        controller.confirm();
        return true;
    }

    public String user(){
        User loggedUser = userLoggedIn ? user : null;
        try{
            return loggedUser.getUsername();
        } catch (NullPointerException ignored){}
        return null;
    }
}
