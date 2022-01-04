package com.przychodniamk2.database.repositories;

import com.przychodniamk2.database.orm.views.EmployeesView;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesViewRepository  extends CrudRepository<EmployeesView, Integer> {
}
