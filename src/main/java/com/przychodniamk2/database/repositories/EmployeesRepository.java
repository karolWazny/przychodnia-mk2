package com.przychodniamk2.database.repositories;

import com.przychodniamk2.database.orm.tables.Employees;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends CrudRepository<Employees, Long> {

}
