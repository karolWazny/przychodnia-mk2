package com.przychodniamk2.unit.database.orm.tables;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Table("DoctorSpecialization")
public class DoctorSpecialization {
    @Column("ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    private Long id;

    @Column("SpecializationsID")
    private Short specializationsID;

    @Column("EmployeesID")
    private Integer employeesID;

    public Short getSpecializationsID() {
        return specializationsID;
    }

    public void setSpecializationsID(Short specializationsID) {
        this.specializationsID = specializationsID;
    }

    public Integer getEmployeesID() {
        return employeesID;
    }

    public void setEmployeesID(Integer employeesID) {
        this.employeesID = employeesID;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
