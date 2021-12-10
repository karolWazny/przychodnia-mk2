package com.przychodniamk2.systemControl.database;

import com.przychodniamk2.business.*;
import org.springframework.context.ApplicationContext;

import java.util.List;

public interface Database {

	void setContext(ApplicationContext context);

	List<Visit> readPlannedVisits(PlannedVisitQueryParameters parameters);

	List<Visit> readPastVisits(Person person);

	void createDoneVisit(DoneVisit visit);

	void createPlannedVisit(ScheduledVisit visit);

	List<Person> readPatients(Person person);

	void createPatient(Person person);

	List<Doctor> readDoctors();

	Date getFirstPossibleAppointmentDate(Doctor doctor);
}