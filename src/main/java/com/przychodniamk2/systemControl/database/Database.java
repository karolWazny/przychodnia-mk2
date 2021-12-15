package com.przychodniamk2.systemControl.database;

import com.przychodniamk2.business.*;
import com.przychodniamk2.database.orm.tables.MedicalVisits;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public interface Database {

	void setContext(ApplicationContext context);

	List<ScheduledVisit> readPlannedVisits(PlannedVisitQueryParameters parameters);

	List<DoneVisit> readPastVisits(Person person);

	void createDoneVisit(DoneVisit visit);

	void createPlannedVisit(ScheduledVisit visit);

	List<Patient> readPatients(Person person);

	void createPatient(Person person);

	List<Doctor> readDoctors();

	Date getFirstPossibleAppointmentDate(Doctor doctor);

	List<Time> getPossibleAppointmentTimes(Doctor doctor, Date date);

	List<ElementOfTreatment> getCurrentDiagnoses();

	List<ElementOfTreatment> getCurrentProcedures();
}