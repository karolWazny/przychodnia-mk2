package com.przychodniamk2.database;

import com.przychodniamk2.business.*;
import com.przychodniamk2.business.Date;
import com.przychodniamk2.business.Time;
import com.przychodniamk2.database.orm.tables.MedicalVisits;
import com.przychodniamk2.database.orm.views.DoctorsView;
import com.przychodniamk2.database.orm.views.PatientsView;
import com.przychodniamk2.database.repositories.*;
import com.przychodniamk2.systemControl.database.Database;
import com.przychodniamk2.systemControl.database.PlannedVisitQueryParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
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
	private PatientsViewRepository patientsViewRepository;

	@Autowired
	private MedicalVisitsRepository medicalVisitsRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void setContext(ApplicationContext context) {
		addressRepository = context.getBean("addressRepository", AddressRepository.class);
		personalsRepository = context.getBean("personalsRepository", PersonalsRepository.class);
	}

	@Override
	public List<ScheduledVisit> readPlannedVisits(PlannedVisitQueryParameters parameters) {
		return null;
	}

	@Override
	public List<DoneVisit> readPastVisits(Person person) {
		return null;
	}

	@Override
	public void createDoneVisit(DoneVisit visit) {
		MedicalVisits visitRecord = new MedicalVisits();
		visitRecord.setDescription(visit.getDescription());
		visitRecord.setScheduledVisitID(visit.getScheduledVisit().getId());
		visitRecord.setIllnessID(visit.getIllness());
		visitRecord.setProcedureID(visit.getProcedure());
		medicalVisitsRepository.save(visitRecord);
	}

	@Override
	public void createPlannedVisit(ScheduledVisit visit) {
		CallableStatement statement;
		String result = "";
		try{
			Connection connection= Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection();
			String sql = "{CALL SCHEDULED_VISITS_INSERT ( ?, ?, ?, ?, ? )}";
			statement = connection.prepareCall(sql);
			statement.setDate(1, sqlDateFrom(visit.getDate()));
			statement.setInt(2, visit.getDoctor().getEmployeeId());
			statement.setInt(3, visit.getPatient().getPatientId());
			statement.setTime(4, sqlTimeFrom(visit.getTime()));
			statement.registerOutParameter(5, Types.VARCHAR);
			statement.executeQuery();
			result = statement.getString(5);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(!result.equals("SUCCESS")){
			throw new RuntimeException();
		}
	}

	private java.sql.Time sqlTimeFrom(Time time){
		return java.sql.Time.valueOf(time.exactTimeString());
	}

	@Override
	public List<Patient> readPatients(Person person) {
		System.out.println("Wyciaganie pacjentow z bazy...");
		Iterable<PatientsView> patientsViews = patientsViewRepository.findAll();
		List<Patient> patients = new LinkedList<>();
		for(PatientsView patient : patientsViews){
			Patient temp = new Patient();
			temp.setFirstName(patient.getFirstName());
			temp.setLastName(patient.getLastName());
			temp.setPesel(patient.getPESEL());
			temp.setDateOfBirth(businessDateFrom(patient.getBirthDate()));
			temp.setPhoneNumber(patient.getPhoneNumber());
			temp.setSex(patient.getGender());
			temp.setPatientId(patient.getID());
			Address address = new Address();
			address.flatNumber = patient.getApartmentNumber();
			address.zipCode = patient.getZIPCode();
			address.buildingNumber = patient.getHouseNumber();
			address.street = patient.getStreet();
			address.city = patient.getTown();
			temp.setAddress(address);
			patients.add(temp);
		}
		return patients;
	}

	private Date businessDateFrom(java.sql.Date date){
		LocalDate localDate = date.toLocalDate();
		return new Date(localDate);
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

	private java.sql.Date sqlDateFrom(Date date){
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
		CallableStatement statement;
		try{
			Connection connection= Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection();
			String sql = "{CALL SELECT_FIRST_POSSIBLE_DATE_BY_DOCTOR_ID ( ?, ? )}";
			statement = connection.prepareCall(sql);
			statement.setInt(1, doctor.getEmployeeId());
			statement.registerOutParameter(2, Types.DATE);
			statement.executeQuery();
			java.sql.Date sqlDate = statement.getDate(2);
			System.out.println(sqlDate);
			return businessDateFrom(sqlDate);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Time> getPossibleAppointmentTimes(Doctor doctor, Date date) {
		CallableStatement statement;
		List<Time> times =  getWorkingHours(doctor).possibleAppointments();
		try{
			Connection connection= Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection();
			String sql = "{CALL SELECT_VISITS_BY_DATE_AND_DOCTOR( ?, ?, ?)}";
			statement = connection.prepareCall(sql);
			statement.setDate(1, sqlDateFrom(date));
			statement.setInt(2, doctor.getEmployeeId());
			statement.registerOutParameter(3, Types.VARCHAR);

			ResultSet resultSet = statement.executeQuery();

			if("SUCCESS".equalsIgnoreCase(statement.getString(3))){
				while(resultSet.next()){
					times.remove(businessTimeFrom(resultSet.getTime(1)));
				}
			}
			return times;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new RuntimeException();
	}

	private WorkingHours getWorkingHours(Doctor doctor){
		CallableStatement statement;
		try{
			Connection connection= Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection();
			String sql = "{CALL SELECT_WORKING_HOURS_BY_EMPLOYEE_ID ( ? )}";
			statement = connection.prepareCall(sql);
			statement.setInt(1, doctor.getEmployeeId());
			ResultSet resultSet = statement.executeQuery();

			Time startTime = new Time();
			Time endTime = new Time();
			while(resultSet.next()){
				java.sql.Time start = resultSet.getTime("Start");
				startTime = businessTimeFrom(start);
				java.sql.Time end = resultSet.getTime("End");
				endTime = businessTimeFrom(end);
			}
			return new WorkingHours(startTime, endTime);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new RuntimeException();
	}

	private Time businessTimeFrom(java.sql.Time time){
		LocalTime localTime = time.toLocalTime();
		return new Time(localTime.getHour(), localTime.getMinute());
	}

	@Override
	public List<ElementOfTreatment> getCurrentDiagnoses() {
		return getElementsOfTreatment("DIAGNOSES");
	}

	@Override
	public List<ElementOfTreatment> getCurrentProcedures() {
		return getElementsOfTreatment("PROCEDURES");
	}

	private List<ElementOfTreatment> getElementsOfTreatment(String type){
		CallableStatement statement;
		List<ElementOfTreatment> output = new LinkedList<>();
		try{
			Connection connection= Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection();
			String sql = "{CALL GET_" + type.toUpperCase() + "_CURRENT_STANDARD ()}";
			statement = connection.prepareCall(sql);
			ResultSet resultSet = statement.executeQuery();

			while(resultSet.next()){
				ElementOfTreatment tmp = new ElementOfTreatment(resultSet.getInt("ID"),
						resultSet.getString("Description"),
						resultSet.getString("Code"));
				output.add(tmp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return output;
	}
}