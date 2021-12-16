package com.przychodniamk2.business;

import java.util.Objects;

public class DoneVisit {
	private ScheduledVisit scheduledVisit;
	private Integer illness;
	private Integer procedure;
	private String description;

	private DoneVisit(ScheduledVisit scheduledVisit, Integer illness, Integer procedure, String description){
		this.scheduledVisit = scheduledVisit;
		this.illness = illness;
		this.procedure = procedure;
		this.description = description;
	}

	public ScheduledVisit getScheduledVisit() {
		return scheduledVisit;
	}

	public Integer getIllness() {
		return illness;
	}

	public Integer getProcedure() {
		return procedure;
	}

	public String getDescription() {
		return description;
	}

	public static class Builder{
		private ScheduledVisit scheduledVisit;
		private String description;
		private Integer medicalProcedure;
		private Integer illness;

		public Builder(ScheduledVisit scheduledVisit){
			this.scheduledVisit = scheduledVisit;
		}

		public Builder withDescription(String description){
			this.description = description;
			return this;
		}

		public Builder withProcedure(Integer procedure){
			this.medicalProcedure = procedure;
			return this;
		}

		public Builder withIllness(Integer illness){
			this.illness = illness;
			return this;
		}

		public DoneVisit build(){
			return new DoneVisit(scheduledVisit, illness, medicalProcedure, description);
		}
	}
}