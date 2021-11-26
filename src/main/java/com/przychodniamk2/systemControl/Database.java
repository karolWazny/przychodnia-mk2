package com.przychodniamk2.systemControl;

import com.przychodniamk2.business.Date;
import com.przychodniamk2.business.Person;
import com.przychodniamk2.business.Visit;
import com.przychodniamk2.database.User;
import org.springframework.context.ApplicationContext;

import java.util.List;

public interface Database {

	public Iterable<User> allUsers();

	public void setContext(ApplicationContext context);

	public Visit readNextVisit(Object aDoctor);

	public List<Visit> readPastVisits(Object aPerson);

	public void createDoneVisit(Object aVisit);

	public void createPlannedVisit(Object aVisit);

	public List<Date> readFreeDates(Object aDoctor);

	public List<Person> readPatients(Object aPatientData);

	public void createPatient(Object aPatientData);
}