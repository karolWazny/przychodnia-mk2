package com.przychodniamk2.systemControl.database.orm.views;

import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Immutable
public class MedicalVisitsView {
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
    private String procedureCode;
    private String procedureStandard;
    private String procedureDescription;
    private String illnessCode;
    private String illnessStandard;
    private String illnessDescription;
    private String visitDescription;

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

    public String getProcedureCode() {
        return procedureCode;
    }

    public String getProcedureStandard() {
        return procedureStandard;
    }

    public String getProcedureDescription() {
        return procedureDescription;
    }

    public String getIllnessCode() {
        return illnessCode;
    }

    public String getIllnessStandard() {
        return illnessStandard;
    }

    public String getIllnessDescription() {
        return illnessDescription;
    }

    public String getVisitDescription() {
        return visitDescription;
    }
}
