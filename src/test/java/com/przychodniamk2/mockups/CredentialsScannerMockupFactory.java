package com.przychodniamk2.mockups;

import com.przychodniamk2.gui.login.Credentials;
import com.przychodniamk2.gui.login.CredentialsScanner;
import com.przychodniamk2.gui.login.CredentialsScannerFactory;

import java.util.Optional;

public class CredentialsScannerMockupFactory implements CredentialsScannerFactory {
    Optional<Credentials> credentials = Optional.empty();

    @Override
    public CredentialsScanner credentialsScanner() {
        return new Mockup(credentials);
    }

    public static class Mockup  implements CredentialsScanner {
        Optional<Credentials> credentials = Optional.empty();
        int tries = 0;

        public Mockup(Optional<Credentials> credentials){
            this.credentials = credentials;
        }

        @Override
        public Optional<Credentials> requestCredentials() {
            tries++;
            if(tries > 100)
                throw new RuntimeException("Too many tries!");
            return credentials;
        }
    }

    public void setCredentials(Optional<Credentials> credentials) {
        this.credentials = credentials;
    }
}
