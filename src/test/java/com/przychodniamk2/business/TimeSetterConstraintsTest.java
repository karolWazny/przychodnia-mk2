package com.przychodniamk2.business;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TimeSetterConstraintsTest implements TimeConstraints{

    @Test
    public void minutesSetterConstraints(){
        Time time = new Time();
        if(valid){
            time.setMinutes(minutes);
            Assertions.assertEquals(minutes, time.getMinutes());
        } else {
            try{
                time.setMinutes(minutes);
                Assertions.fail("Illegal minutes value should trigger an exception.\n" +
                        "Value: " + minutes);
            } catch (IllegalArgumentException ignored) {}
        }
    }

    @Parameterized.Parameter(value = 0)
    public int minutes;

    @Parameterized.Parameter(value = 1)
    public boolean valid;
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{ {0, true}, {-1, false}, {1, true}, {59, true}, {30, true}, {60, false}, {61, false}};
        return Arrays.asList(data);
    }
}
