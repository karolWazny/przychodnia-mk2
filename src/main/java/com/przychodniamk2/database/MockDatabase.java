package com.przychodniamk2.database;

import com.przychodniamk2.business.*;
import com.przychodniamk2.systemControl.Database;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class MockDatabase implements Database {
    @Override
    public Iterable<User> allUsers() {
        return null;
    }

    @Override
    public void setContext(ApplicationContext context) {

    }

    @Override
    public Visit readNextVisit(Object aDoctor) {
        return null;
    }

    @Override
    public List<Visit> readPastVisits(Object aPerson) {
        return null;
    }

    @Override
    public void createDoneVisit(Object aVisit) {
        System.out.println(aVisit);
    }

    @Override
    public void createPlannedVisit(Object aVisit) {

    }

    @Override
    public List<Date> readFreeDates(Object aDoctor) {
        return null;
    }

    @Override
    public List<Person> readPatients(Object aPatientData) {
        return null;
    }

    @Override
    public void createPatient(Object aPatientData) {

    }

    @Override
    public List<Doctor> readDoctors(Object doctorData) {
        List<Doctor> doctors = new LinkedList<>();
        doctors.add(new Doctor("Bob", "Ross", null, new Specialization("ortopeda"), 3));
        doctors.add(new Doctor("Mark", "Twain", null, new Specialization("kardiolog"), 5));

        return doctors;
    }
}
