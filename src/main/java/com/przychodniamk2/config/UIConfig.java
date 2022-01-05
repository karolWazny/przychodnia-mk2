package com.przychodniamk2.config;

import com.przychodniamk2.business.User;
import com.przychodniamk2.gui.changepassword.JavaFXPasswordChanger;
import com.przychodniamk2.gui.choosedoctor.JavaFXDoctorChooser;
import com.przychodniamk2.gui.addvisit.JavaFXVisitPlanner;
import com.przychodniamk2.gui.choosepatient.JavaFXPatientChooser;
import com.przychodniamk2.gui.createpatient.JavaFXPatientCreator;
import com.przychodniamk2.gui.createuser.JavaFXUserCreator;
import com.przychodniamk2.gui.displaydonevisit.JavaFXDoneVisitDisplayer;
import com.przychodniamk2.gui.login.JavaFXLogInService;
import com.przychodniamk2.gui.login.LogInDialog;
import com.przychodniamk2.gui.performvisit.JavaFXVisitPerformer;
import com.przychodniamk2.systemControl.usecase.*;
import com.przychodniamk2.systemControl.SystemController;
import com.przychodniamk2.systemControl.UserInteractionController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Access;

@Configuration
public class UIConfig {
    private JavaFXLogInService javaFXLogInService;

    @Autowired
    public void setJavaFXLogInService(JavaFXLogInService javaFXLogInService) {
        this.javaFXLogInService = javaFXLogInService;
    }

    @Bean
    public DoctorChooser doctorChooser(){
        return new JavaFXDoctorChooser();
    }

    @Bean
    public UserInteractionController userInteractionController(){
        return new SystemController();
    }

    @Bean
    public VisitPlanner visitPlanner(){
        return new JavaFXVisitPlanner();
    }

    @Bean
    public PatientChooser patientChooser(){
        return new JavaFXPatientChooser();
    }

    @Bean
    public PatientCreator patientCreator(){
        return new JavaFXPatientCreator();
    }

    @Bean
    public VisitPerformer visitPerformer(){
        return new JavaFXVisitPerformer();
    }

    @Bean
    public DoneVisitDisplayer doneVisitDisplayer(){
        return new JavaFXDoneVisitDisplayer();
    }

    @Bean
    public LogInService logInService(){
        return this.javaFXLogInService;
    }

    @Bean
    public User loggedUser(){
        return this.javaFXLogInService.getLoggedUser();
    }

    @Bean
    public UserCreator userCreator(){
        return new JavaFXUserCreator();
    }

    @Bean
    public PasswordChanger passwordChanger(){
        return new JavaFXPasswordChanger();
    }
}
