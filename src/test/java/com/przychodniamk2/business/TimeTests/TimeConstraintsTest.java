package com.przychodniamk2.business.TimeTests;

import com.przychodniamk2.business.Time;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TimeConstraintsTest implements TimeConstraints{
    TimeConstraintsData data;

    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    @Before
    public void setUp(){
        data = new TimeConstraintsData();
    }

    @Test
    public void constructorConstraintsTest(){
        for(TimeConstraintsData.Entity entity : data.sampleData) {
            if(entity.valid){
                Time time = new Time(entity.hour, entity.minutes);
                Assertions.assertEquals(entity.hour, time.getHour());
                Assertions.assertEquals(entity.minutes, time.getMinutes());
            } else {
                exception.expect(IllegalArgumentException.class);
                Time time = new Time(entity.hour, entity.minutes);
            }
        }
    }
}
