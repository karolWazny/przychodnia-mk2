package com.przychodniamk2.systemControl.database.repositories;

import com.przychodniamk2.systemControl.database.orm.views.PatientsView;
import org.springframework.data.repository.CrudRepository;

public interface PatientsViewRepository extends CrudRepository<PatientsView, Integer> {
}
