package com.przychodniamk2.acceptance;

import com.przychodniamk2.gui.changepassword.ChangePasswordController;
import fit.ColumnFixture;

public class ChangePassword extends ColumnFixture {
    private ChangePasswordController controller = new ChangePasswordController();

    private boolean userLoggedIn;
    private String newPass;
    private String repeatNewPass;
    private String oldPass;

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
        return false;
    }

    public String user(){
        return null;
    }
}
