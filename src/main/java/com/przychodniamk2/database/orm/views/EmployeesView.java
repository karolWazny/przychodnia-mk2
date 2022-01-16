package com.przychodniamk2.database.orm.views;

import org.hibernate.annotations.Immutable;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

//@Entity
@Immutable
@Table("EmployeesView")
public class EmployeesView {
    //Tutaj jedynie gettery porobione
    //https://thorben-janssen.com/spring-data-jpa-views/
    @Id
    @Column("ID")
    private Integer ID;

    @Column("Position")
    private String positionsName;

    @Column("FirstName")
    private String firstName;

    @Column("LastName")
    private String LastName;

    @Column("PhoneNumber")
    private String phoneNumber;

    public Integer getID() {
        return ID;
    }

    public String getPositionsName() {
        return positionsName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPositionsName(String positionsName) {
        this.positionsName = positionsName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }
}
