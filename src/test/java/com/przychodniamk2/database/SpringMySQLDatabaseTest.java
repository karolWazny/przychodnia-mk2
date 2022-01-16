package com.przychodniamk2.database;

import com.przychodniamk2.business.Date;
import com.przychodniamk2.business.Doctor;
import com.przychodniamk2.business.Time;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class SpringMySQLDatabaseTest {

    static Data testData = new Data();
    private CallableStatementVisitsByDateAndDoctorMock statement1;
    private CallableWorkingHoursByEmployeeMock statement2;
    private JdbcTemplate template;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = testData.data;
        return Arrays.asList(data);
    }

    @Parameterized.Parameter(value = 0)
    public String start;

    @Parameterized.Parameter(value = 1)
    public String end;

    @Parameterized.Parameter(value = 2)
    public Object[][] scheduledVisitsTimes;

    @Parameterized.Parameter(value = 3)
    public Time[] possibleAppointmentsTimes;

    @Before
    public void setUp(){
        JdbcTemplateMock jdbcTemplate = new JdbcTemplateMock();
        DataSourceMock dataSourceMock = new DataSourceMock();
        ConnectionMock connectionMock = new ConnectionMock();
        statement1 = new CallableStatementVisitsByDateAndDoctorMock();
        statement2 = new CallableWorkingHoursByEmployeeMock();

        connectionMock.setVisitsByDateAndDoctor(statement1);
        connectionMock.setWorkingHoursByEmployee(statement2);

        dataSourceMock.setConnectionMock(connectionMock);

        jdbcTemplate.setDataSourceMock(dataSourceMock);

        this.template = jdbcTemplate;
    }

    @Test
    public void getPossibleAppointmentsTimes(){
        statement1.setResultSet(scheduledVisitsTimes);
        statement2.setResult(new Object[][]{{java.sql.Time.valueOf(start), java.sql.Time.valueOf(end), }});
        SpringMySQLDatabase database = new SpringMySQLDatabase();

        database.setJdbcTemplate(this.template);
        List<Time> appointmentTimes = database.getPossibleAppointmentTimes(new Doctor(null,null, null, 0), new Date());

        List<Time> expectedResult = Arrays.asList(possibleAppointmentsTimes);

        Assertions.assertEquals(expectedResult, appointmentTimes);
    }
}
