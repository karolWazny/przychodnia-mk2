package com.przychodniamk2.database.orm.views;

import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Immutable
public class PatientsView {
    //Tutaj jedynie gettery porobione
    //https://thorben-janssen.com/spring-data-jpa-views/
    @Id
    private Long ID;

    private String PESEL;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private java.sql.Date birthDate;
    private char gender;
    private String ZIPCode;
    private String town;
    private String street;
    private String houseNumber;
    private String apartmentNumber;

    public Long getID() {
        return ID;
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

    public String getApartmentNumber() {
        return apartmentNumber;
    }
}
