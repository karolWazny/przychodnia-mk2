package com.przychodniamk2.database.orm.tables;

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
    private Long id;

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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
