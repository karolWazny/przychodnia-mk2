package com.przychodniamk2.database.repositories;

import com.przychodniamk2.database.orm.tables.Specializations;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecializationsRepository extends CrudRepository<Specializations, Long> {

}
