package com.przychodniamk2.systemControl;

import com.przychodniamk2.business.*;
import com.przychodniamk2.systemControl.usecase.*;
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

    @Autowired
    private PatientCreator patientCreator;

    @Autowired
    private VisitPerformer visitPerformer;

    @Override
    public Person choosePatient() {
        return patientChooser.choosePatient();
    }

    @Override
    public Date chooseDate(Doctor doctor) {
        return Date.today();
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
        return null;
    }

    @Override
    public void performVisit(ScheduledVisit visit) {
        visitPerformer.performVisit();
    }

    @Override
    public void addPatient() {
        patientCreator.createPatient();
    }
}
