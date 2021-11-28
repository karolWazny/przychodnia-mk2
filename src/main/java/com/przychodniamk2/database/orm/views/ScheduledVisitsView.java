package com.przychodniamk2.database.orm.views;

import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Immutable
public class ScheduledVisitsView {
    //Tutaj jedynie gettery porobione
    //https://thorben-janssen.com/spring-data-jpa-views/
    @Id
    private Long ID;

    private java.sql.Date date;
    private String doctorsFirstName;
    private String doctorsLastName;
    private String patientsPESEL;
    private String patientsFirstName;
    private String patientsLastName;

    public Long getID() {
        return ID;
    }

    public Date getDate() {
        return date;
    }

    public String getDoctorsFirstName() {
        return doctorsFirstName;
    }

    public String getDoctorsLastName() {
        return doctorsLastName;
    }

    public String getPatientsPESEL() {
        return patientsPESEL;
    }

    public String getPatientsFirstName() {
        return patientsFirstName;
    }

    public String getPatientsLastName() {
        return patientsLastName;
    }
}
