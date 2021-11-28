package com.przychodniamk2.database.repositories;

import com.przychodniamk2.database.orm.tables.Addresses;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Addresses, Integer> {

}
