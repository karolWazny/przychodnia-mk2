package com.przychodniamk2.systemControl.database.orm.tables;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.sql.Date;

@Table("Log")
public class Log {
    @Column("ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    private Integer ID;

    @Column("Date")
    private Date date;

    @Column("Description")
    private String description;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
