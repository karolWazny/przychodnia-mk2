package com.przychodniamk2.database.orm.views;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MedicalVisitsView {
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
