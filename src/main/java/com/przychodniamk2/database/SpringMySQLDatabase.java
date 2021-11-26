package com.przychodniamk2.database;

import com.przychodniamk2.business.Date;
import com.przychodniamk2.business.Person;
import com.przychodniamk2.business.Visit;
import com.przychodniamk2.systemControl.Database;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpringMySQLDatabase implements Database {
	private UserRepository userRepository;

	@Override
	public Iterable<User> allUsers() {
		return userRepository.findAll();
	}

	@Override
	public void setContext(ApplicationContext context) {
		userRepository = context.getBean("userRepository", UserRepository.class);
	}

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