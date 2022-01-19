package com.przychodniamk2.systemControl.database.orm.tables;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Table("Addresses")
public class Addresses {
    @Column("ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    private Integer ID;

    @Column("Street")
    private String street;

    @Column("ZIPCode")
    private String zipCode;

    @Column("Town")
    private String town;

    @Column("HouseNumber")
    private String houseNumber;

    @Column("ApartmentNumber")
    private Short apartmentNumber;

    public Integer getId() {
        return ID;
    }

    public void setId(Integer ID) {
        this.ID = ID;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Short getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(Short apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
