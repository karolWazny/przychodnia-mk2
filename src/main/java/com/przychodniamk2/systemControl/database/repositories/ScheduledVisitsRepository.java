package com.przychodniamk2.systemControl.database.repositories;

import com.przychodniamk2.systemControl.database.orm.tables.ScheduledVisits;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduledVisitsRepository extends CrudRepository<ScheduledVisits, Long> {

}
