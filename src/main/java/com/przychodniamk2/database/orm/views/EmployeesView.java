package com.przychodniamk2.database.orm.views;

import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Immutable
public class EmployeesView {
    //Tutaj jedynie gettery porobione
    //https://thorben-janssen.com/spring-data-jpa-views/
    @Id
    private Long ID;

    private String positionsName;
    private String firstName;
    private String LastName;
    private String phoneNumber;

    public Long getID() {
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
}
