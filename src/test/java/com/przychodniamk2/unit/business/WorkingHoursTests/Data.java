package com.przychodniamk2.unit.business.WorkingHoursTests;

import com.przychodniamk2.unit.business.Time;

public class Data {
    public static Object[][] data = new Object[][]{ {new Time(10, 0), new Time(10, 0), false},
            {new Time(10, 0), new Time(9, 0), false},
            {new Time(10, 0), new Time(10, 30), true},
            {new Time(10, 0), new Time(11, 0), true}};
}
