package com.przychodniamk2.systemControl.database.repositories;

import com.przychodniamk2.systemControl.database.orm.tables.ElementsOfTreatment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElementsOfTreatmentRepository extends CrudRepository<ElementsOfTreatment, Long> {

}
