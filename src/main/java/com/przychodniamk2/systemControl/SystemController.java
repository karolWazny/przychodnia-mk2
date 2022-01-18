package com.przychodniamk2.systemControl;

import com.przychodniamk2.unit.business.*;
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
    private PastPatientsVisitBrowser pastPatientsVisitBrowser;
    private DoctorPlannedVisitBrowser doctorPlannedVisitBrowser;
    private LogInService logInService;
    private UserCreator userCreator;
    private PasswordChanger passwordChanger;

    @Autowired
    public void setPasswordChanger(PasswordChanger passwordChanger) {
        this.passwordChanger = passwordChanger;
    }

    @Autowired
    public void setUserCreator(UserCreator userCreator) {
        this.userCreator = userCreator;
    }

    @Autowired
    public void setLogInService(LogInService logInService) {
        this.logInService = logInService;
    }

    @Autowired
    public void setDoctorPlannedVisitBrowser(DoctorPlannedVisitBrowser doctorPlannedVisitBrowser) {
        this.doctorPlannedVisitBrowser = doctorPlannedVisitBrowser;
    }

    @Autowired
    public void setPastPatientsVisitBrowser(PastPatientsVisitBrowser pastPatientsVisitBrowser) {
        this.pastPatientsVisitBrowser = pastPatientsVisitBrowser;
    }

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
    public Doctor chooseDoctor() {
        return doctorChooser.chooseDoctor();
    }

    @Override
    public void addVisit() {
        visitPlanner.addVisit();
    }

    @Override
    public void performVisit(ScheduledVisit visit) {
        visitPerformer.performVisit(visit);
    }

    @Override
    public void addPatient() {
        patientCreator.createPatient();
    }

    @Override
    public void browsePastVisits(Patient patient) {
        pastPatientsVisitBrowser.browseVisits(patient);
    }

    @Override
    public ScheduledVisit browseDoctorsPlannedVisits(Doctor doctor) {
        return doctorPlannedVisitBrowser.browseVisits(doctor);
    }

    @Override
    public boolean logIn() {
        //todo test
        return logInService.logIn();
    }

    @Override
    public User getLoggedUser() {
        //todo test
        return logInService.getLoggedUser();
    }

    @Override
    public void createNewUser() {
        //todo security layer
        //todo test
        userCreator.createNewUser();
    }

    @Override
    public void changePassword() {
        passwordChanger.changePassword();
    }
}
