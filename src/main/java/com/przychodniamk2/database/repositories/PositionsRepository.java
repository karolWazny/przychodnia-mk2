package com.przychodniamk2.database.repositories;

import com.przychodniamk2.database.orm.tables.Positions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionsRepository extends CrudRepository<Positions, Long> {

}