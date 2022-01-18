package com.przychodniamk2.unit.database.orm.tables;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Table("MedicalVisits")
public class MedicalVisits {
    @Column("ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    private Long id;

    @Column("Description")
    private String description;

    @Column("ScheduledVisitsID")
    private Integer scheduledVisitID;

    @Column("IllnessID")
    private Integer illnessID;

    @Column("ProcedureID")
    private Integer procedureID;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getScheduledVisitID() {
        return scheduledVisitID;
    }

    public void setScheduledVisitID(Integer scheduledVisitID) {
        this.scheduledVisitID = scheduledVisitID;
    }

    public Integer getIllnessID() {
        return illnessID;
    }

    public void setIllnessID(Integer illnessID) {
        this.illnessID = illnessID;
    }

    public Integer getProcedureID() {
        return procedureID;
    }

    public void setProcedureID(Integer procedureID) {
        this.procedureID = procedureID;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
