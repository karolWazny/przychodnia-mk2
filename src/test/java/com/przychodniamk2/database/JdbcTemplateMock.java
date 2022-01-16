package com.przychodniamk2.database;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class JdbcTemplateMock extends JdbcTemplate {
    @Override
    public DataSource getDataSource(){
        return new DataSourceMock();
    }
}
