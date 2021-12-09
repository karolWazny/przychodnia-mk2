package com.przychodniamk2.systemControl;

import com.przychodniamk2.business.*;
import com.przychodniamk2.systemControl.usecase.DoctorChooser;
import com.przychodniamk2.systemControl.usecase.PatientChooser;
import com.przychodniamk2.systemControl.usecase.VisitPlanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemController implements UserInteractionController {
    @Autowired
    private DoctorChooser doctorChooser;

    @Autowired
    private VisitPlanner visitPlanner;

    @Autowired
    private PatientChooser patientChooser;

    @Override
    public Person choosePatient() {
        return patientChooser.choosePatient();
    }

    @Override
    public Date chooseDate(Doctor doctor) {
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
    public void addVisit() {
        visitPlanner.addVisit();
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
