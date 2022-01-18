package com.przychodniamk2.unit.database.repositories;

import com.przychodniamk2.unit.database.orm.views.EmployeesView;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesViewRepository  extends CrudRepository<EmployeesView, Integer> {
}
