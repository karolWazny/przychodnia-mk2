package com.przychodniamk2.business;

import java.util.Objects;

public class DoneVisit implements Visit {
	private ScheduledVisit scheduledVisit;
	private String illness;
	private String procedure;
	private String description;

	private DoneVisit(ScheduledVisit scheduledVisit, String illness, String procedure, String description){
		this.scheduledVisit = Objects.requireNonNull(scheduledVisit);
		this.illness = Objects.requireNonNull(illness);
		this.procedure = Objects.requireNonNull(procedure);
		this.description = Objects.requireNonNull(description);
	}

	public ScheduledVisit getScheduledVisit() {
		return scheduledVisit;
	}

	public String getIllness() {
		return illness;
	}

	public String getProcedure() {
		return procedure;
	}

	public String getDescription() {
		return description;
	}

	public static class Builder{
		private ScheduledVisit scheduledVisit;
		private String description;
		private String medicalProcedure;
		private String illness;

		public Builder(ScheduledVisit scheduledVisit){
			this.scheduledVisit = scheduledVisit;
		}

		public Builder withDescription(String description){
			this.description = description;
			return this;
		}

		public Builder withProcedure(String procedure){
			this.medicalProcedure = procedure;
			return this;
		}

		public Builder withIllness(String illness){
			this.illness = illness;
			return this;
		}

		public DoneVisit build(){
			return new DoneVisit(scheduledVisit, illness, medicalProcedure, description);
		}
	}
}