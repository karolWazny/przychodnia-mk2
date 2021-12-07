package com.przychodniamk2.config;

import com.przychodniamk2.gui.choosedoctor.JavaFXDoctorChooser;
import com.przychodniamk2.gui.addvisit.JavaFXVisitPlanner;
import com.przychodniamk2.systemControl.usecase.DoctorChooser;
import com.przychodniamk2.systemControl.SystemController;
import com.przychodniamk2.systemControl.UserInteractionController;
import com.przychodniamk2.systemControl.usecase.VisitPlanner;
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
}
