package com.przychodniamk2.business;

public class DoneVisit {
	private ScheduledVisit scheduledVisit;
	private ElementOfTreatment illness;
	private ElementOfTreatment procedure;
	private String description;

	private DoneVisit(ScheduledVisit scheduledVisit, ElementOfTreatment illness, ElementOfTreatment procedure, String description){
		this.scheduledVisit = scheduledVisit;
		this.illness = illness;
		this.procedure = procedure;
		this.description = description;
	}

	public ScheduledVisit getScheduledVisit() {
		return scheduledVisit;
	}

	public ElementOfTreatment getIllness() {
		return illness;
	}

	public ElementOfTreatment getProcedure() {
		return procedure;
	}

	public String getDescription() {
		return description;
	}

	public Patient getPatient(){
		return getScheduledVisit().getPatient();
	}

	public Doctor getDoctor(){
		return getScheduledVisit().getDoctor();
	}

	public Date getDate(){
		return getScheduledVisit().getDate();
	}

	public Time getTime(){
		return getScheduledVisit().getTime();
	}

	@Override
	public String toString(){
		return getDate().toString() + " " + getDoctor().getSpecialization();
	}

	public static class Builder{
		private ScheduledVisit scheduledVisit;
		private String description;
		private ElementOfTreatment medicalProcedure;
		private ElementOfTreatment illness;

		public Builder(ScheduledVisit scheduledVisit){
			this.scheduledVisit = scheduledVisit;
		}

		public Builder withDescription(String description){
			this.description = description;
			return this;
		}

		public Builder withProcedure(ElementOfTreatment procedure){
			this.medicalProcedure = procedure;
			return this;
		}

		public Builder withIllness(ElementOfTreatment illness){
			this.illness = illness;
			return this;
		}

		public DoneVisit build(){
			return new DoneVisit(scheduledVisit, illness, medicalProcedure, description);
		}
	}
}