package com.przychodniamk2.systemControl.database.repositories;

import com.przychodniamk2.systemControl.database.orm.views.DoctorsView;
import org.springframework.data.repository.CrudRepository;

public interface DoctorsViewRepository extends CrudRepository<DoctorsView, Integer> {
}
