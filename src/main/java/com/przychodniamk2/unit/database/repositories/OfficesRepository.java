package com.przychodniamk2.unit.database.repositories;

import com.przychodniamk2.unit.database.orm.tables.Offices;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficesRepository extends CrudRepository<Offices, Long> {

}
