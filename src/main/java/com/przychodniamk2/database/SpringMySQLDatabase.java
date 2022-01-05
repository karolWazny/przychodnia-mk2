package com.przychodniamk2.database;

import com.przychodniamk2.business.*;
import com.przychodniamk2.business.Date;
import com.przychodniamk2.business.Time;
import com.przychodniamk2.database.orm.tables.MedicalVisits;
import com.przychodniamk2.database.orm.views.EmployeesView;
import com.przychodniamk2.database.repositories.*;
import com.przychodniamk2.systemControl.database.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class SpringMySQLDatabase implements Database {
	private MedicalVisitsRepository medicalVisitsRepository;
	private EmployeesViewRepository employeesViewRepository;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setEmployeesViewRepository(EmployeesViewRepository employeesViewRepository) {
		this.employeesViewRepository = employeesViewRepository;
	}

	@Autowired
	public void setMedicalVisitsRepository(MedicalVisitsRepository medicalVisitsRepository) {
		this.medicalVisitsRepository = medicalVisitsRepository;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void setContext(ApplicationContext context) {

	}

	@Override
	public List<ScheduledVisit> readPlannedVisits(Doctor doctor, Date date) {
		CallableStatement statement;
		try{
			Connection connection= Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection();
			String sql = "{CALL SELECT_ON_DATE_SCHEDULED_VISITS_BY_EMPLOYEESID ( ?, ? )}";
			statement = connection.prepareCall(sql);
			statement.setInt(1, doctor.getEmployeeId());
			statement.setDate(2, sqlDateFrom(date));
			ResultSet resultSet = statement.executeQuery();
			List<ScheduledVisit> visits = new LinkedList<>();

			while(resultSet.next()){
				Patient patient = new Patient();
				patient.setPesel(resultSet.getString("PatientsPESEL"));
				patient.setFirstName(resultSet.getString("PatientsFirstName"));
				patient.setLastName(resultSet.getString("PatientsLastName"));
				patient.setPatientId(resultSet.getInt("PatientsID"));

				ScheduledVisit scheduledVisit = new ScheduledVisit.Builder().withDoctor(doctor)
						.at(businessTimeFrom(resultSet.getTime("Time")))
						.day(date)
						.withPatient(patient)
						.withId(resultSet.getInt("ID"))
						.build();

				visits.add(scheduledVisit);
			}
			return visits;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new RuntimeException();
	}

	@Override
	public List<DoneVisit> readPastVisits(Patient person) {
		CallableStatement statement;
		try{
			Connection connection= Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection();
			String sql = "{CALL SELECT_MEDICAL_VISITS_VIEW_BY_PATIENT_ID ( ? )}";
			statement = connection.prepareCall(sql);
			statement.setInt(1, person.getPatientId());
			ResultSet resultSet = statement.executeQuery();
			List<DoneVisit> visits = new LinkedList<>();

			while(resultSet.next()){
				ElementOfTreatment illness = new ElementOfTreatment(resultSet.getString("IllnessDescription"),
						resultSet.getString("IllnessCode"));
				ElementOfTreatment procedure = new ElementOfTreatment(resultSet.getString("ProcedureDescription"),
						resultSet.getString("ProcedureCode"));
				Doctor doctor = new Doctor(resultSet.getString("DoctorsFirstName"),
						resultSet.getString("DoctorsLastName"),
						null,
						new Specialization(resultSet.getString("DoctorsSpecialization")),
						null);
				Date date = businessDateFrom(resultSet.getDate("Date"));
				String description = resultSet.getString("VisitDescription");

				ScheduledVisit scheduledVisit = new ScheduledVisit.Builder()
						.withPatient(person)
						.withDoctor(doctor)
						.day(date)
						.build();
				DoneVisit doneVisit = new DoneVisit.Builder(scheduledVisit)
						.withDescription(description)
						.withIllness(illness)
						.withProcedure(procedure)
						.build();
				visits.add(doneVisit);
			}
			return visits;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new RuntimeException();
	}

	@Override
	public void createDoneVisit(DoneVisit visit) {
		MedicalVisits visitRecord = new MedicalVisits();
		visitRecord.setDescription(visit.getDescription());
		visitRecord.setScheduledVisitID(visit.getScheduledVisit().getId());
		visitRecord.setIllnessID(visit.getIllness().getId());
		visitRecord.setProcedureID(visit.getProcedure().getId());
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
			System.out.println(result);
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
		CallableStatement statement;
		try{
			Connection connection= Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection();
			String sql = "{CALL  SELECT_PATIENT_BY_PESEL_AND_NAME ( ?, ?, ? )}";
			statement = connection.prepareCall(sql);
			statement.setString(1, person.getPesel());
			statement.setString(2, person.getFirstName());
			statement.setString(3, person.getLastName());
			ResultSet resultSet = statement.executeQuery();

			List<Patient> patients = new LinkedList<>();

			while(resultSet.next()){
				patients.add(patientFromResultSet(resultSet));
			}
			return patients;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new RuntimeException();
	}

	private Patient patientFromResultSet(ResultSet resultSet) throws SQLException {
		Patient temp = new Patient();
		temp.setFirstName(resultSet.getString("FirstName"));
		temp.setLastName(resultSet.getString("LastName"));
		temp.setPesel(resultSet.getString("PESEL"));
		temp.setDateOfBirth(businessDateFrom(resultSet.getDate("BirthDate")));
		temp.setPhoneNumber(resultSet.getString("PhoneNumber"));
		temp.setSex(resultSet.getString("Gender").charAt(0));
		temp.setPatientId(resultSet.getInt("PatientID"));

		Address address = new Address();
		address.flatNumber = resultSet.getShort("ApartmentNumber");
		address.zipCode = resultSet.getString("ZIPCode");
		address.buildingNumber = resultSet.getString("HouseNumber");
		address.street = resultSet.getString("Street");
		address.city = resultSet.getString("Town");
		temp.setAddress(address);

		return temp;
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
		CallableStatement statement;
		try{
			Connection connection= Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection();
			String sql = "{CALL SELECT_CURRENTLY_WORKING_DOCTORS ()}";
			statement = connection.prepareCall(sql);
			ResultSet resultSet = statement.executeQuery();
			List<Doctor> doctors = new LinkedList<>();
			while(resultSet.next()){
				doctors.add(new Doctor(resultSet.getString("FirstName"),
						resultSet.getString("LastName"),
						null,
						new Specialization(resultSet.getString("specialization")),
						resultSet.getInt("EmployeesID")));
			}
			return doctors;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new RuntimeException();
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

	@Override
	public User logIn(String user, String password) {
		CallableStatement statement;
		try{
			Connection connection= Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection();
			String sql = "{CALL LOG_IN (?, ?, ?, ?)}";
			statement = connection.prepareCall(sql);
			statement.setString(1, user);
			statement.setString(2, password);
			statement.registerOutParameter(3, Types.INTEGER);
			statement.registerOutParameter(4, Types.VARCHAR);
			statement.executeQuery();
			Integer employeeId = statement.getInt(3);
			String result = statement.getString(4);
			if(!result.equalsIgnoreCase("SUCCESS"))
				return null;
			Optional<EmployeesView> optionalView = employeesViewRepository.findById(employeeId);
			if(optionalView.isEmpty()){
				return null;
			}
			EmployeesView view = optionalView.get();
			return new User(new Employee(view.getFirstName(), view.getLastName(), view.getID(), view.getPositionsName()), user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new RuntimeException();
	}

	@Override
	public void createUser(User user, String password) {
		throw new UnsupportedOperationException();
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