package com.przychodniamk2.unit.database;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class JdbcTemplateMock extends JdbcTemplate {
    DataSourceMock dataSourceMock = new DataSourceMock();

    public void setDataSourceMock(DataSourceMock dataSourceMock) {
        this.dataSourceMock = dataSourceMock;
    }

    @Override
    public DataSource getDataSource(){
        return dataSourceMock;
    }
}
