package com.przychodniamk2.database.repositories;

import com.przychodniamk2.database.orm.tables.Personals;
import org.springframework.data.repository.CrudRepository;

public interface PersonalsRepository extends CrudRepository<Personals, Long> {
}
