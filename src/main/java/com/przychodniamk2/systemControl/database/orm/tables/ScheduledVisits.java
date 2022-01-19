package com.przychodniamk2.systemControl.database.orm.tables;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.sql.Date;

@Table("ScheduledVisits")
public class ScheduledVisits {
    @Column("ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    private Long id;

    @Column("Date")
    private Date date;

    @Column("EmployeesID")
    private Integer employeesID;

    @Column("PatientsID")
    private Integer patientsID;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getEmployeesID() {
        return employeesID;
    }

    public void setEmployeesID(Integer employeesID) {
        this.employeesID = employeesID;
    }

    public Integer getPatientsID() {
        return patientsID;
    }

    public void setPatientsID(Integer patientsID) {
        this.patientsID = patientsID;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
