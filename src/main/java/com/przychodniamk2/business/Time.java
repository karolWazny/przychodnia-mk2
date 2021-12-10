package com.przychodniamk2.business;

import java.util.Calendar;

public class Time {
    private final int hour;
    private final int minutes;

    public Time(int hours, int minutes) {
        this.hour = hours;
        this.minutes = minutes;
    }

    public static Time now(){
        Calendar now = Calendar.getInstance();
        int hours = now.get(Calendar.HOUR_OF_DAY);
        int minutes = now.get(Calendar.MINUTE);
        return new Time(hours, minutes);
    }

    public int getHour() {
        return hour;
    }

    public int getMinutes() {
        return minutes;
    }

    @Override
    public String toString(){
        return "" + hour + ":" + minutes;
    }
}