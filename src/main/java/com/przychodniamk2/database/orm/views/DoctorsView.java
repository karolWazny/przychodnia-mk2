package com.przychodniamk2.database.orm.views;

import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Immutable
public class DoctorsView {
    //Tutaj jedynie gettery porobione
    //https://thorben-janssen.com/spring-data-jpa-views/
    @Id
    private Long ID;

    private String position;
    private String specialization;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Long getID() {
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
}
