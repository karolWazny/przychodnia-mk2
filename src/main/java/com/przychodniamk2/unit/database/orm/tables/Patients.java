package com.przychodniamk2.unit.database.orm.tables;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Table("Patients")
public class Patients {
    @Column("ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    private Long id;

    @Column("PersonalsID")
    private Integer persolnalsID;

    public Integer getPersolnalsID() {
        return persolnalsID;
    }

    public void setPersolnalsID(Integer persolnalsID) {
        this.persolnalsID = persolnalsID;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
