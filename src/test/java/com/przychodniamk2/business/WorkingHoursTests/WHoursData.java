package com.przychodniamk2.business.WorkingHoursTests;

import com.przychodniamk2.business.WorkingHours;
import com.przychodniamk2.business.Time;

public class WHoursData {

    public static WorkingHours referenceHours = new WorkingHours(new Time(8, 0), new Time(16, 0));

    public static Time times[] = new Time[]{
            new Time(7, 50),
            new Time(8, 0),
            new Time(12, 0),
            new Time(16, 0),
            new Time(16, 50)
    };
}
