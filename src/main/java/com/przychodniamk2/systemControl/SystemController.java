package com.przychodniamk2.systemControl;

import com.przychodniamk2.business.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemController implements UserInteractionController {
    @Autowired
    private DoctorChooser doctorChooser;
    @Override
    public Person choosePatient() {
        return new Person(new Address(), "Jan", "Kowalski");
    }

    @Override
    public Date chooseDate() {
        return new Date();
    }

    @Override
    public Doctor chooseDoctor() {
        return doctorChooser.chooseDoctor();
    }

    @Override
    public void addDoctor(Doctor doctor) {

    }

    @Override
    public void addVisit(ScheduledVisit visit) {

    }

    @Override
    public ScheduledVisit chooseVisit() {
        return new ScheduledVisit();
    }

    @Override
    public void performVisit(ScheduledVisit visit) {

    }

    @Override
    public void addPatient(Person patient) {

    }
}
