package com.przychodniamk2.database;

import com.przychodniamk2.business.*;
import com.przychodniamk2.business.Date;
import com.przychodniamk2.business.Time;
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
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Service
public class SpringMySQLDatabase implements Database {
	private AddressRepository addressRepository;
	private PersonalsRepository personalsRepository;
	@Autowired
	private DoctorsViewRepository doctorsViewRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;

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
		CallableStatement statement;
		try{
			Connection connection= Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection();
			String sql = "{CALL PATIENTS_INSERT ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )}";
			statement = connection.prepareCall(sql);
			statement.setString(1, person.getPesel());
			statement.setString(2, person.getFirstName());
			statement.setString(3, person.getLastName());
			statement.setString(4, person.getPhoneNumber());
			statement.setDate(5, sqlDateFrom(person.getDateOfBirth()));
			statement.setString(6, person.getSex().toString());
			statement.setString(7, person.getAddress().zipCode);
			statement.setString(8, person.getAddress().city);
			statement.setString(9, person.getAddress().street);
			statement.setString(10, person.getAddress().buildingNumber);
			statement.setShort(11, person.getAddress().flatNumber);
			ResultSet resultSet = statement.executeQuery();
			boolean next = resultSet.next();
			System.out.println(next);
			if(next){
				String string = resultSet.getString(1);
				System.out.println("DEBUG: " + string);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public java.sql.Date sqlDateFrom(Date date){
		LocalDate localDate = LocalDate.of(date.getYear(), date.getMonth(), date.getDay());
		return java.sql.Date.valueOf(localDate);
	}

	@Override
	public List<Doctor> readDoctors() {
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