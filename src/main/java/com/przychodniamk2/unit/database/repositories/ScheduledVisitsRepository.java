package com.przychodniamk2.unit.database.repositories;

import com.przychodniamk2.unit.database.orm.tables.ScheduledVisits;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduledVisitsRepository extends CrudRepository<ScheduledVisits, Long> {

}
