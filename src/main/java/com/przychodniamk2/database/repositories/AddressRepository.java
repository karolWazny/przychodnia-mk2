package com.przychodniamk2.database.repositories;

import com.przychodniamk2.database.orm.tables.Addresses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.Optional;

@Repository
public interface AddressRepository extends CrudRepository<Addresses, Long> {

}
