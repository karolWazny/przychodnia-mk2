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
        System.out.println("Created visit: " + visit);
    }

    @Override
    public List<Patient> readPatients(Person person) {
        List<Patient> patients = new LinkedList<>();
        patients.add(new Patient("Bob", "Ross", new Date(), "1233",null));
        patients.add(new Patient("Jan", "Kowalski", new Date(), "1724", null));
        patients.add(new Patient("Jack", "Daniels", new Date(), "3254", null));
        patients.add(new Patient("Sherlock", "Holmes", new Date(), "9896", null));
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
