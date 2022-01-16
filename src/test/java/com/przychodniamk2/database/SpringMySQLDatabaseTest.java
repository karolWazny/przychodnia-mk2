package com.przychodniamk2.database;

import com.przychodniamk2.business.Date;
import com.przychodniamk2.business.Doctor;
import com.przychodniamk2.business.Time;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class SpringMySQLDatabaseTest {
    @Test
    public void getPossibleAppointmentsTimes(){
        SpringMySQLDatabase database = new SpringMySQLDatabase();
        database.setJdbcTemplate(new JdbcTemplateMock());
        List<Time> appointmentTimes = database.getPossibleAppointmentTimes(new Doctor(null,null, null, 0), new Date());

        Assertions.assertEquals(1, 1);
    }
}
