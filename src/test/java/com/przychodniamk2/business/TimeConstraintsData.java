package com.przychodniamk2.business;

public class TimeConstraintsData {
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
