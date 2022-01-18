package com.przychodniamk2.systemControl.database;

import com.przychodniamk2.unit.business.*;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface Database {

	void setContext(ApplicationContext context);
	List<ScheduledVisit> readPlannedVisits(Doctor doctor, Date date);
	List<DoneVisit> readPastVisits(Patient person);
	void createDoneVisit(DoneVisit visit);
	void createPlannedVisit(ScheduledVisit visit);
	List<Patient> readPatients(Person person);
	void createPatient(Person person);
	List<Doctor> readDoctors();
	Date getFirstPossibleAppointmentDate(Doctor doctor);
	List<Time> getPossibleAppointmentTimes(Doctor doctor, Date date); //tutaj
	List<ElementOfTreatment> getCurrentDiagnoses();
	List<ElementOfTreatment> getCurrentProcedures();
    User logIn(String user, String password); //tutaj
	void createUser(User user, String password);
	void changePassword(String user, String oldPassword, String newPassword); //tutaj
}