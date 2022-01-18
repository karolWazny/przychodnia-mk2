package com.przychodniamk2.systemControl.usecase;

import com.przychodniamk2.business.User;

public interface LogInService {
    boolean logIn();
    User getLoggedUser();
}
