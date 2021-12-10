package com.przychodniamk2.database;

import com.przychodniamk2.business.*;
import com.przychodniamk2.database.orm.tables.Personals;
import com.przychodniamk2.database.orm.views.DoctorsView;
import com.przychodniamk2.database.repositories.AddressRepository;
import com.przychodniamk2.database.repositories.DoctorsViewRepository;
import com.przychodniamk2.database.repositories.PersonalsRepository;
import com.przychodniamk2.database.repositories.UserRepository;
import com.przychodniamk2.systemControl.database.Database;
import com.przychodniamk2.systemControl.database.PlannedVisitQueryParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class SpringMySQLDatabase implements Database {
	private AddressRepository addressRepository;
	private PersonalsRepository personalsRepository;
	@Autowired
	private DoctorsViewRepository doctorsViewRepository;

	@Override
	public void setContext(ApplicationContext context) {
		addressRepository = context.getBean("addressRepository", AddressRepository.class);
		personalsRepository = context.getBean("personalsRepository", PersonalsRepository.class);
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
		System.out.println("Wyciaganie pacjentow z bazy...");
		throw new UnsupportedOperationException();
	}

	@Override
	public void createPatient(Person person) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Doctor> readDoctors() {
		System.out.println("DEBUG: Wyciaganie doktorow z bazy...");
		Iterable<DoctorsView> doctorViews = doctorsViewRepository.findAll();
		List<Doctor> doctors = new LinkedList<>();
		for(DoctorsView doctorsView : doctorViews){
			doctors.add(new Doctor(doctorsView.getFirstName(), doctorsView.getLastName(), null, new Specialization(doctorsView.getSpecialization()), doctorsView.getEmployeeId()));
		}
		return doctors;
	}

	@Override
	public Date getFirstPossibleAppointmentDate(Doctor doctor) {
		return null;
	}

	@Override
	public List<Time> getPossibleAppointmentTimes(Doctor doctor, Date date) {
		return null;
	}
}