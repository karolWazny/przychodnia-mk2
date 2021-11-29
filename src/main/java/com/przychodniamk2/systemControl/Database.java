package com.przychodniamk2.systemControl;

import com.przychodniamk2.business.Date;
import com.przychodniamk2.business.Person;
import com.przychodniamk2.business.Visit;
import com.przychodniamk2.database.User;
import org.springframework.context.ApplicationContext;

import java.util.List;

public interface Database {

	Iterable<User> allUsers();

	void setContext(ApplicationContext context);

	Visit readNextVisit(Object aDoctor);

	List<Visit> readPastVisits(Object aPerson);

	void createDoneVisit(Object aVisit);

	void createPlannedVisit(Object aVisit);

	List<Date> readFreeDates(Object aDoctor);

	List<Person> readPatients(Object aPatientData);

	void createPatient(Object aPatientData);
}