package com.przychodniamk2.unit.database.orm.tables;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Table("Offices")
public class Offices {
    @Column("ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    private Long id;

    @Column("Name")
    private String name;

    @Column("StartOfWork")
    private String startOfWork;

    @Column("EndOfWork")
    private String endOfWork;

    @Column("EmployeesID")
    private Integer employeesID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartOfWork() {
        return startOfWork;
    }

    public void setStartOfWork(String startOfWork) {
        this.startOfWork = startOfWork;
    }

    public String getEndOfWork() {
        return endOfWork;
    }

    public void setEndOfWork(String endOfWork) {
        this.endOfWork = endOfWork;
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
