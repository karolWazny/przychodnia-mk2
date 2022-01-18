package com.przychodniamk2.unit.business.TimeTests;

import com.przychodniamk2.unit.business.Time;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class HourSetterConstraintsTest {

    @Test
    public void minutesSetterConstraints(){
        Time time = new Time();
        if(valid){
            time.setHour(hours);
            Assertions.assertEquals(hours, time.getHour());
        } else {
            try{
                time.setHour(hours);
                Assertions.fail("Illegal hours value should trigger an exception.\n" +
                        "Value: " + hours);
            } catch (IllegalArgumentException ignored) {}
        }
    }

    @Parameterized.Parameter(value = 0)
    public int hours;

    @Parameterized.Parameter(value = 1)
    public boolean valid;
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{ {0, true}, {-1, false}, {1, true}, {12, true}, {30, false}, {24, false}, {23, true}};
        return Arrays.asList(data);
    }
}
