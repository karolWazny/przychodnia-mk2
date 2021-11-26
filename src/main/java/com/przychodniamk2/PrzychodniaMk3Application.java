package com.przychodniamk2;

import com.przychodniamk2.database.UserRepository;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrzychodniaMk3Application{
    @Autowired
    private UserRepository userRepository;

    public UserRepository getRepo(){
        return userRepository;
    }

    public static void main(String[] args) {
        Application.launch(FrontEnd.class, args);
    }
}