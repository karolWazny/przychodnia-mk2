package com.przychodniamk2.database.orm.views;

import org.hibernate.annotations.Immutable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Id;
import java.sql.Date;

@Table("PatientsView")
@Immutable
public class PatientsView {

    @Id
    @Column("PatientID")
    private Integer PatientID;

    @Column("ID")
    private Integer ID;

    @Column("PESEL")
    private String PESEL;

    @Column("FirstName")
    private String firstName;

    @Column("LastName")
    private String lastName;

    @Column("PhoneNumber")
    private String phoneNumber;

    @Column("BirthDate")
    private java.sql.Date birthDate;

    @Column("Gender")
    private char gender;

    @Column("ZIPCode")
    private String ZIPCode;

    @Column("Town")
    private String town;

    @Column("Street")
    private String street;

    @Column("HouseNumber")
    private String houseNumber;

    @Column("ApartmentNumber")
    private Short apartmentNumber;

    public Integer getID() {
        return PatientID;
    }

    public String getPESEL() {
        return PESEL;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public char getGender() {
        return gender;
    }

    public String getZIPCode() {
        return ZIPCode;
    }

    public String getTown() {
        return town;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public Short getApartmentNumber() {
        return apartmentNumber;
    }
}
