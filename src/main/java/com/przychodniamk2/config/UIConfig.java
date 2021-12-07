package com.przychodniamk2.config;

import com.przychodniamk2.gui.JavaFXDoctorChooser;
import com.przychodniamk2.gui.JavaFXVisitPlanner;
import com.przychodniamk2.systemControl.DoctorChooser;
import com.przychodniamk2.systemControl.SystemController;
import com.przychodniamk2.systemControl.UserInteractionController;
import com.przychodniamk2.systemControl.VisitPlanner;
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
