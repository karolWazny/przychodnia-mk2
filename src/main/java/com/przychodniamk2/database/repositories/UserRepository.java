package com.przychodniamk2.database.repositories;

import com.przychodniamk2.database.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}