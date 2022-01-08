package com.przychodniamk2.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TimeTest {
    @Test
    void equalityTest() {
        assertEquals(new Time(4, 50), new Time(4, 50));
    }

    @Test
    void notEqualityMinutesTest() {
        assertNotEquals(new Time(4, 50), new Time(4, 55));
    }

    @Test
    void notEqualityHoursTest() {
        assertNotEquals(new Time(3, 55), new Time(4, 55));
    }

    @Test
    void notEqualityDifferentClassesTest() {
        assertNotEquals(new Time(3, 55), "some string instance");
    }
}
