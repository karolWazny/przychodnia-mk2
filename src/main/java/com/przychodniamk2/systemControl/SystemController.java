package com.przychodniamk2.systemControl;

import com.przychodniamk2.business.Date;
import com.przychodniamk2.business.Doctor;
import com.przychodniamk2.business.Person;
import com.przychodniamk2.business.ScheduledVisit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemController implements UserInteractionController {
    @Autowired
    private DoctorChooser doctorChooser;
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
        return null;
    }

    @Override
    public void performVisit(ScheduledVisit visit) {

    }

    @Override
    public void addPatient(Person patient) {

    }
}
