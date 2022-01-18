package com.przychodniamk2.unit.business.TimeTests;

import com.przychodniamk2.unit.business.Time;

public class TimeData {

    public static Time referenceTime = new Time(10, 10);

    public static Time timesEquals[] = new Time[]{
            new Time(1, 1),
            new Time(2, 4),
            new Time(3, 3),
            new Time(4, 2),
            new Time(5, 1)
    };

    public static Time timesBefore[] = new Time[]{
            new Time(10, 30),
            new Time(10, 10),
            new Time(8, 2),
            new Time(7, 20),
            new Time(1, 15)
    };

}
