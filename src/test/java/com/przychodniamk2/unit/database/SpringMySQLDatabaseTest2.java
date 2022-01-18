package com.przychodniamk2.unit.database;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.integration.junit4.JMockit;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(JMockit.class)
public class SpringMySQLDatabaseTest2 {
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

    @Tested
    public SpringMySQLDatabase database;

    @Test
    public void passwordChangedSuccessfully() throws SQLException {
        new Expectations(){{
            jdbcTemplate.getDataSource(); returns(dataSource);
            dataSource.getConnection(); returns(connection);
            connection.prepareCall("{CALL CHANGE_PASSWORD (?, ?, ?, ?)}"); returns(statement);
            statement.getString(4); returns("success");
        }};
        database.setJdbcTemplate(jdbcTemplate);
        database.changePassword("username", "oldPasswordCorrect", "strongNewPassword");
    }

    @Test
    public void passwordChangeFails() throws SQLException {
        new Expectations(){{
            jdbcTemplate.getDataSource(); returns(dataSource);
            dataSource.getConnection(); returns(connection);
            connection.prepareCall("{CALL CHANGE_PASSWORD (?, ?, ?, ?)}"); returns(statement);
            statement.getString(4); returns("fail message");
        }};
        database.setJdbcTemplate(jdbcTemplate);
        exception.expect(RuntimeException.class);
        exception.expectMessage("fail message");
        database.changePassword("username", "oldPasswordCorrect", "strongNewPassword");
    }
}
