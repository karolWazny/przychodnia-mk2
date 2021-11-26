package com.przychodniamk3;

import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrzychodniaMk3Application{
    @Autowired
    private UserRepository userRepository;

    private static PrzychodniaMk3Application instance;

    public static UserRepository getRepository(){
        return instance.userRepository;
    }

    public PrzychodniaMk3Application(){
        instance = this;
    }

    public UserRepository getRepo(){
        return userRepository;
    }

    public static void main(String[] args) {
        Application.launch(FrontEnd.class, args);
    }
}