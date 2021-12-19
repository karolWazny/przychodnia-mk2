package com.przychodniamk2.config;

import com.przychodniamk2.gui.choosedoctor.JavaFXDoctorChooser;
import com.przychodniamk2.gui.addvisit.JavaFXVisitPlanner;
import com.przychodniamk2.gui.choosepatient.JavaFXPatientChooser;
import com.przychodniamk2.gui.createpatient.JavaFXPatientCreator;
import com.przychodniamk2.gui.displaydonevisit.JavaFXDoneVisitDisplayer;
import com.przychodniamk2.gui.performvisit.JavaFXVisitPerformer;
import com.przychodniamk2.systemControl.usecase.*;
import com.przychodniamk2.systemControl.SystemController;
import com.przychodniamk2.systemControl.UserInteractionController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UIConfig {
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
}
