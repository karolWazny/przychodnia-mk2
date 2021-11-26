package com.przychodniamk3.database;

import com.przychodniamk3.business.Date;
import com.przychodniamk3.business.Person;
import com.przychodniamk3.business.Visit;
import com.przychodniamk3.systemControl.Database;

import java.util.List;

public class SpringMySQLDatabase implements Database {

	@Override
	public Visit readNextVisit(Object aDoctor) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Visit> readPastVisits(Object aPerson) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void createDoneVisit(Object aVisit) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void createPlannedVisit(Object aVisit) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Date> readFreeDates(Object aDoctor) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Person> readPatients(Object aPatientData) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void createPatient(Object aPatientData) {
		throw new UnsupportedOperationException();
	}
}