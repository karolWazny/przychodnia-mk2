package com.przychodniamk2.systemControl;

import com.przychodniamk2.business.*;
import com.przychodniamk2.systemControl.usecase.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemController implements UserInteractionController {
    private DoctorChooser doctorChooser;
    private VisitPlanner visitPlanner;
    private PatientChooser patientChooser;
    private PatientCreator patientCreator;
    private VisitPerformer visitPerformer;

    @Autowired
    public void setDoctorChooser(DoctorChooser doctorChooser) {
        this.doctorChooser = doctorChooser;
    }

    @Autowired
    public void setVisitPlanner(VisitPlanner visitPlanner) {
        this.visitPlanner = visitPlanner;
    }

    @Autowired
    public void setPatientChooser(PatientChooser patientChooser) {
        this.patientChooser = patientChooser;
    }

    @Autowired
    public void setPatientCreator(PatientCreator patientCreator) {
        this.patientCreator = patientCreator;
    }

    @Autowired
    public void setVisitPerformer(VisitPerformer visitPerformer) {
        this.visitPerformer = visitPerformer;
    }

    @Override
    public Patient choosePatient() {
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
        visitPerformer.performVisit(visit);
    }

    @Override
    public void addPatient() {
        patientCreator.createPatient();
    }
}
