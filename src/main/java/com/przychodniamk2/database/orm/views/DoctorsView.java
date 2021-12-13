package com.przychodniamk2.database.orm.views;

import org.hibernate.annotations.Immutable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Entity;
import javax.persistence.Id;

@Immutable
@Table("DoctorsView")
//@Entity
public class DoctorsView {
    //Tutaj jedynie gettery porobione
    //https://thorben-janssen.com/spring-data-jpa-views/
    @Id
    private Integer ID;

    @Column("ID")
    private String position;
    @Column("specialization")
    private String specialization;
    @Column("FirstName")
    private String firstName;
    @Column("LastName")
    private String lastName;
    @Column("PhoneNumber")
    private String phoneNumber;
    @Column("EmployeesID")
    private Integer employeeId;

    public Integer getID() {
        return ID;
    }

    public String getPosition() {
        return position;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
}
