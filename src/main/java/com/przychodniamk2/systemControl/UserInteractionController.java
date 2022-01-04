package com.przychodniamk2.systemControl;

import com.przychodniamk2.business.*;
import org.springframework.stereotype.Service;

@Service
public interface UserInteractionController {
    Patient choosePatient();
    Date chooseDate(Doctor doctor);
    Doctor chooseDoctor();
    void addDoctor(Doctor doctor);
    void addVisit();
    ScheduledVisit chooseVisit();
    void performVisit(ScheduledVisit visit);
    void addPatient();
    void browsePastVisits(Patient patient);
    ScheduledVisit browseDoctorsPlannedVisits(Doctor doctor);
    boolean logIn();
    void createNewUser();
}
