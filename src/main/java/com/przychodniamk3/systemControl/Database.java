package com.przychodniamk3.systemControl;

import com.przychodniamk3.business.Date;
import com.przychodniamk3.business.Person;
import com.przychodniamk3.business.Visit;

import java.util.List;

public interface Database {

	public Visit readNextVisit(Object aDoctor);

	public List<Visit> readPastVisits(Object aPerson);

	public void createDoneVisit(Object aVisit);

	public void createPlannedVisit(Object aVisit);

	public List<Date> readFreeDates(Object aDoctor);

	public List<Person> readPatients(Object aPatientData);

	public void createPatient(Object aPatientData);
}