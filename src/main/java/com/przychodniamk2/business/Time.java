package com.przychodniamk2.business;

import java.util.Calendar;

public class Time {
    private final int hour;
    private final int minutes;

    public Time(int hours, int minutes) {
        if(argumentsNotValid(hours, minutes))
            throw new IllegalArgumentException();
        this.hour = hours;
        this.minutes = minutes;
    }

    private static boolean argumentsNotValid(int hours, int minutes){
        return hours > 23 || hours < 0 || minutes > 59 || minutes < 0;
    }

    public Time() {
        this(0, 0);
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

    public String exactTimeString(){
        return this + ":00";
    }

    @Override
    public String toString(){
        return String.format("%02d", hour) + ":" + String.format("%02d", minutes);
    }

    @Override
    public boolean equals(Object o){
        return (o instanceof Time)
                && ((Time) o).hour == hour
                && ((Time) o).minutes == minutes;
    }
}
