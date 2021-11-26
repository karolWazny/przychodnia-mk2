package com.przychodniamk3;

import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrzychodniaMk2Application{
    @Autowired
    private UserRepository userRepository;

    private static PrzychodniaMk2Application instance;

    public static UserRepository getRepository(){
        return instance.userRepository;
    }

    public PrzychodniaMk2Application(){
        instance = this;
    }

    public UserRepository getRepo(){
        return userRepository;
    }

    public static void main(String[] args) {
        Application.launch(FrontEnd.class, args);
    }
}