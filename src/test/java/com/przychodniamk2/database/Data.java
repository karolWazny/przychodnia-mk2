package com.przychodniamk2.database;

import com.przychodniamk2.business.Time;

public class Data {
    public Object[][] data  = {{"10:00:00", "14:00:00",
            new Object[][]{{java.sql.Time.valueOf("10:00:00")}, {java.sql.Time.valueOf("11:00:00")}},
            new Time[]{new Time(10, 30), new Time(11, 30), new Time(12, 0), new Time(12, 30), new Time(13, 0), new Time(13, 30), }},
            {"9:00:00", "12:30:00",
            new Object[][]{{java.sql.Time.valueOf("9:30:00")}, {java.sql.Time.valueOf("10:00:00")}, {java.sql.Time.valueOf("10:30:00")}, {java.sql.Time.valueOf("11:00:00")}, {java.sql.Time.valueOf("11:30:00")}},
            new Time[]{new Time(9, 0), new Time(12, 0)}},
            {"9:00:00", "12:30:00",
            new Object[][]{{java.sql.Time.valueOf("9:00:00")}, {java.sql.Time.valueOf("9:30:00")}, {java.sql.Time.valueOf("10:00:00")}, {java.sql.Time.valueOf("10:30:00")}, {java.sql.Time.valueOf("11:00:00")}, {java.sql.Time.valueOf("11:30:00")}, {java.sql.Time.valueOf("12:00:00")}},
            new Time[]{}},
    };
}
