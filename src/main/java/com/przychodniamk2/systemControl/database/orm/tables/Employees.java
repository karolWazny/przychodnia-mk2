package com.przychodniamk2.systemControl.database.orm.tables;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Table("Employees")
public class Employees {
    @Column("ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    private Integer id;

    @Column("PositionsID")
    private Integer positionsID;

    @Column("PersonalsID")
    private Integer personalsID;

    public Integer getPositionsID() {
        return positionsID;
    }

    public void setPositionsID(Integer positionsID) {
        this.positionsID = positionsID;
    }

    public Integer getPersonalsID() {
        return personalsID;
    }

    public void setPersonalsID(Integer personalsID) {
        this.personalsID = personalsID;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
