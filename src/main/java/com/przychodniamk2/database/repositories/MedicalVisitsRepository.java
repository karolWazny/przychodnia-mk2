package com.przychodniamk2.database.repositories;

import com.przychodniamk2.database.orm.tables.MedicalVisits;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalVisitsRepository extends CrudRepository<MedicalVisits, Long> {
    
}
