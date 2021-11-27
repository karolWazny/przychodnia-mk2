package com.przychodniamk2.database.orm.tables;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employees {
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
