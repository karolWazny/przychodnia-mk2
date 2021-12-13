package com.przychodniamk2.business;

public class ScheduledVisit implements Visit {
	private final Date date;
	private final Time time;
	private final Person patient;
	private final Doctor doctor;

	public ScheduledVisit(Doctor doctor, Person patient, Date date, Time time){
		this.date = date;
		this.time = time;
		this.patient = patient;
		this.doctor = doctor;
	}

	public Date getDate() {
		return date;
	}

	public Time getTime() {
		return time;
	}

	public Person getPatient() {
		return patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public static class Builder {
		private Doctor doctor;
		private Date date;
		private Person patient;
		private Time time;

		public Builder withDoctor(Doctor doctor){
			this.doctor = doctor;
			return this;
		}
		public Builder withPatient(Person patient){
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

		public ScheduledVisit build(){
			return new ScheduledVisit(doctor, patient, date, time);
		}
	}
}