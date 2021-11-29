package com.przychodniamk2.systemControl;

import com.przychodniamk2.business.Date;
import com.przychodniamk2.business.Doctor;
import com.przychodniamk2.business.Person;
import com.przychodniamk2.business.ScheduledVisit;

public class SystemController implements UserInteractionController {
    @Override
    public Person choosePatient() {
        return null;
    }

    @Override
    public Date chooseDate() {
        return null;
    }

    @Override
    public Doctor chooseDoctor() {
        return null;
    }

    @Override
    public void addDoctor(Doctor doctor) {

    }

    @Override
    public void addVisit(ScheduledVisit visit) {

    }

    @Override
    public ScheduledVisit chooseVisit() {
        return null;
    }

    @Override
    public void performVisit(ScheduledVisit visit) {

    }

    @Override
    public void addPatient(Person patient) {

    }
}
