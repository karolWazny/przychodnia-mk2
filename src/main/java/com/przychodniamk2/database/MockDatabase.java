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
        List<Person> patients = new LinkedList<>();
        patients.add(new Person("Bob", "Ross", "1233",null));
        patients.add(new Person("Jan", "Kowalski", "1724", null));
        patients.add(new Person("Jack", "Daniels", "3254", null));
        patients.add(new Person("Sherlock", "Holmes", "9896", null));
        return patients;
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

    @Override
    public Date getFirstPossibleAppointmentDate(Doctor doctor) {
        return Date.today();
    }

    @Override
    public List<Time> getPossibleAppointmentTimes(Doctor doctor, Date date) {
        List<Time> times = new LinkedList<>();
        for(int i = 0; i < 16; i++){
            times.add(new Time(8 + i / 2, 30 * (i % 2)));
        }
        return times;
    }
}
