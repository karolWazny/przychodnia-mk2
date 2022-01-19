package com.przychodniamk2.mockups;

import com.przychodniamk2.business.*;
import com.przychodniamk2.systemControl.database.Database;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class MockupDatabase implements Database {
    @Override
    public void setContext(ApplicationContext context) {

    }

    @Override
    public List<ScheduledVisit> readPlannedVisits(Doctor doctor, Date date) {
        return null;
    }

    @Override
    public List<DoneVisit> readPastVisits(Patient person) {
        return null;
    }

    @Override
    public void createDoneVisit(DoneVisit visit) {

    }

    @Override
    public void createPlannedVisit(ScheduledVisit visit) {

    }

    @Override
    public List<Patient> readPatients(Person person) {
        return null;
    }

    @Override
    public void createPatient(Person person) {

    }

    @Override
    public List<Doctor> readDoctors() {
        return null;
    }

    @Override
    public Date getFirstPossibleAppointmentDate(Doctor doctor) {
        return null;
    }

    @Override
    public List<Time> getPossibleAppointmentTimes(Doctor doctor, Date date) {
        return null;
    }

    @Override
    public List<ElementOfTreatment> getCurrentDiagnoses() {
        return null;
    }

    @Override
    public List<ElementOfTreatment> getCurrentProcedures() {
        return null;
    }

    @Override
    public User logIn(String user, String password) {
        return null;
    }

    @Override
    public void createUser(User user, String password) {

    }

    @Override
    public void changePassword(String user, String oldPassword, String newPassword) {

    }
}
