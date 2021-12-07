package com.przychodniamk2.systemControl;

import com.przychodniamk2.business.Date;
import com.przychodniamk2.business.Doctor;
import com.przychodniamk2.business.Person;
import com.przychodniamk2.business.ScheduledVisit;

public interface UserInteractionController {
    Person choosePatient();
    Date chooseDate();
    Doctor chooseDoctor();
    void addDoctor(Doctor doctor);
    void addVisit();
    ScheduledVisit chooseVisit();
    void performVisit(ScheduledVisit visit);
    void addPatient(Person patient);
}
