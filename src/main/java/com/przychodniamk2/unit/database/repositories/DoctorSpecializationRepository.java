package com.przychodniamk2.unit.database.repositories;

import com.przychodniamk2.unit.database.orm.tables.DoctorSpecialization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorSpecializationRepository extends CrudRepository<DoctorSpecialization, Long> {

}
