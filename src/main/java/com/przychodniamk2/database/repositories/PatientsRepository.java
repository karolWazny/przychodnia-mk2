package com.przychodniamk2.database.repositories;

import com.przychodniamk2.database.orm.tables.Patients;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientsRepository extends CrudRepository<Patients, Long> {

}
