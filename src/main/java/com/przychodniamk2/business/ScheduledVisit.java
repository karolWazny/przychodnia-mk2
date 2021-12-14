package com.przychodniamk2.business;

public class ScheduledVisit implements Visit {
	private final Date date;
	private final Time time;
	private final Patient patient;
	private final Doctor doctor;
	private final Integer id;

	public ScheduledVisit(Doctor doctor, Patient patient, Date date, Time time, Integer id){
		this.date = date;
		this.time = time;
		this.patient = patient;
		this.doctor = doctor;
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public Time getTime() {
		return time;
	}

	public Patient getPatient() {
		return patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public Integer getId(){
		return id;
	}

	public static class Builder {
		private Doctor doctor;
		private Date date;
		private Patient patient;
		private Time time;
		private Integer id;

		public Builder withDoctor(Doctor doctor){
			this.doctor = doctor;
			return this;
		}
		public Builder withPatient(Patient patient){
			this.patient = patient;
			return this;
		}
		public Builder day(Date date){
			this.date = date;
			return this;
		}
		public Builder at(Time time){
			this.time = time;
			return this;
		}
		public Builder withId(Integer id){
			this.id = id;
			return this;
		}

		public ScheduledVisit build(){
			return new ScheduledVisit(doctor, patient, date, time, id);
		}
	}
}