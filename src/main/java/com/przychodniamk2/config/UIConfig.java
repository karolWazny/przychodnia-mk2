package com.przychodniamk2.config;

import com.przychodniamk2.gui.JavaFXDoctorChooser;
import com.przychodniamk2.systemControl.DoctorChooser;
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
}
