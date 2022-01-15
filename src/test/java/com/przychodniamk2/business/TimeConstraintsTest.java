package com.przychodniamk2.business;

import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TimeConstraintsTest {
    Data data;

    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    @Before
    public void setUp(){
        data = new Data();
    }

    @Test
    public void constructorConstraintsTest(){
        Assertions.assertEquals(1, 1);
        for(Data.Entity entity : data.sampleData) {
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

    public static class Data {
        public Entity[] sampleData = { new Entity(0, 0, true),
                new Entity(0, 1, true),
                new Entity(1, 0, true),
                new Entity(1, 1, true),
                new Entity(-1, 0, false),
                new Entity(0, -1, false),
                new Entity(25, 0, false),
                new Entity(24, 3, false),
                new Entity(3, 60, false),
                new Entity(23, 61, false),
                new Entity(23, 59, true) };

        public static class Entity {
            public int hour;
            public int minutes;
            public boolean valid;

            public Entity(int hour, int minutes, boolean valid) {
                this.hour = hour;
                this.minutes = minutes;
                this.valid = valid;
            }
        }
    }
}
