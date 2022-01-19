package com.przychodniamk2.gui.login;

import java.util.Optional;

public interface CredentialsScanner {
    Optional<Credentials> requestCredentials();
}
