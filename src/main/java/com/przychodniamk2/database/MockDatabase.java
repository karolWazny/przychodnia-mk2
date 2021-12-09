package com.przychodniamk2.database;

import com.przychodniamk2.business.*;
import com.przychodniamk2.systemControl.database.Database;
import com.przychodniamk2.systemControl.database.PlannedVisitQueryParameters;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class MockDatabase implements Database {

    @Override
    public void setContext(ApplicationContext context) {

    }

    @Override
    public List<Visit> readPlannedVisits(PlannedVisitQueryParameters parameters) {
        return null;
    }

    @Override
    public List<Visit> readPastVisits(Person person) {
        return null;
    }

    @Override
    public void createDoneVisit(DoneVisit visit) {

    }

    @Override
    public void createPlannedVisit(ScheduledVisit visit) {

    }

    @Override
    public List<Person> readPatients(Person person) {
        return null;
    }

    @Override
    public void createPatient(Person person) {

    }


    @Override
    public List<Doctor> readDoctors() {
        List<Doctor> doctors = new LinkedList<>();
        doctors.add(new Doctor("Bob", "Ross", null, new Specialization("ortopeda"), 3));
        doctors.add(new Doctor("Mark", "Twain", null, new Specialization("kardiolog"), 5));

        return doctors;
    }
}
