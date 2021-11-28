package com.przychodniamk2.database;

import com.przychodniamk2.business.Date;
import com.przychodniamk2.business.Person;
import com.przychodniamk2.business.Visit;
import com.przychodniamk2.database.orm.tables.Personals;
import com.przychodniamk2.database.repositories.AddressRepository;
import com.przychodniamk2.database.repositories.PersonalsRepository;
import com.przychodniamk2.database.repositories.UserRepository;
import com.przychodniamk2.systemControl.Database;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpringMySQLDatabase implements Database {
	private UserRepository userRepository;
	private AddressRepository addressRepository;
	private PersonalsRepository personalsRepository;

	@Override
	public Iterable<User> allUsers() {
		return userRepository.findAll();
	}

	@Override
	public void setContext(ApplicationContext context) {
		userRepository = context.getBean("userRepository", UserRepository.class);
		addressRepository = context.getBean("addressRepository", AddressRepository.class);
		personalsRepository = context.getBean("personalsRepository", PersonalsRepository.class);
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
		personalsRepository.save((Personals) aPatientData);
	}
}