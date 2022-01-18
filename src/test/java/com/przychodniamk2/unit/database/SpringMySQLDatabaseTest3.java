package com.przychodniamk2.unit.database;

import com.przychodniamk2.unit.business.Employee;
import com.przychodniamk2.unit.business.User;
import com.przychodniamk2.unit.database.orm.views.EmployeesView;
import com.przychodniamk2.unit.database.repositories.EmployeesViewRepository;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.integration.junit4.JMockit;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

@RunWith(JMockit.class)
public class SpringMySQLDatabaseTest3 {
    final Integer MAGIC_CONSTANT = 42;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Injectable
    JdbcTemplate jdbcTemplate;

    @Injectable
    DataSource dataSource;

    @Injectable
    Connection connection;

    @Injectable
    CallableStatement statement;

    @Injectable
    EmployeesViewRepository employeesViewRepository;

    @Tested
    SpringMySQLDatabase database;

    EmployeesView employeesView;

    @Before
    public void setup(){
        employeesView = new EmployeesView();
        employeesView.setID(MAGIC_CONSTANT);
        employeesView.setFirstName("Jan");
        employeesView.setLastName("Kowalski");
        employeesView.setPositionsName("admin");
    }

    @Test
    public void successfulLogIn() throws SQLException {
        new Expectations(){{
            jdbcTemplate.getDataSource(); returns(dataSource);
            dataSource.getConnection(); returns(connection);
            connection.prepareCall("{CALL LOG_IN (?, ?, ?, ?)}"); returns(statement);
            statement.getString(4); returns("success");
            statement.getInt(3); returns(MAGIC_CONSTANT);
            employeesViewRepository.findById(MAGIC_CONSTANT); returns(Optional.of(employeesView));
        }};
        database.setJdbcTemplate(jdbcTemplate);
        database.setEmployeesViewRepository(employeesViewRepository);
        User user = database.logIn("username", "valid password");
        Assertions.assertEquals("Jan", user.getEmployee().getFirstName());
        Assertions.assertEquals("Kowalski", user.getEmployee().getLastName());
        Assertions.assertEquals(Employee.Position.ADMIN, user.getEmployee().getPosition());
        Assertions.assertEquals(MAGIC_CONSTANT, user.getEmployee().getEmployeeId());
        Assertions.assertEquals("username", user.getUsername());
    }

    @Test
    public void validCredentialsNoEmployeesView() throws SQLException {
        new Expectations(){{
            jdbcTemplate.getDataSource(); returns(dataSource);
            dataSource.getConnection(); returns(connection);
            connection.prepareCall("{CALL LOG_IN (?, ?, ?, ?)}"); returns(statement);
            statement.getString(4); returns("success");
            statement.getInt(3); returns(MAGIC_CONSTANT);
            employeesViewRepository.findById(MAGIC_CONSTANT); returns(Optional.empty());
        }};
        database.setJdbcTemplate(jdbcTemplate);
        database.setEmployeesViewRepository(employeesViewRepository);
        User user = database.logIn("username", "valid password");
        Assertions.assertNull(user);
    }

    @Test
    public void incorrectCredentials() throws SQLException {
        new Expectations(){{
            jdbcTemplate.getDataSource(); returns(dataSource);
            dataSource.getConnection(); returns(connection);
            connection.prepareCall("{CALL LOG_IN (?, ?, ?, ?)}"); returns(statement);
            statement.getString(4); returns("fail");
            statement.getInt(3); returns(0);
        }};
        database.setJdbcTemplate(jdbcTemplate);
        database.setEmployeesViewRepository(employeesViewRepository);
        User user = database.logIn("username", "invalid password");
        Assertions.assertNull(user);
    }
}
