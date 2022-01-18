package com.przychodniamk2.systemControl;

import com.przychodniamk2.business.*;
import org.springframework.stereotype.Service;

@Service
public interface UserInteractionController {
    Patient choosePatient();
    Doctor chooseDoctor();
    void addVisit();
    void performVisit(ScheduledVisit visit);
    void addPatient();
    void browsePastVisits(Patient patient);
    ScheduledVisit browseDoctorsPlannedVisits(Doctor doctor);
    boolean logIn();
    User getLoggedUser();
    void createNewUser();
    void changePassword();
}
