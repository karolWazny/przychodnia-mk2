package com.przychodniamk2.business;

import java.util.Calendar;

public class Time {
    private int hour;
    private int minutes;

    public Time(int hours, int minutes) {
        if(argumentsNotValid(hours, minutes))
            throw new IllegalArgumentException();
        this.hour = hours;
        this.minutes = minutes;
    }

    private static boolean argumentsNotValid(int hours, int minutes){
        return !validHour(hours) || !validMinutes(minutes);
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

    public void setHour(int hour) {
        if(!validHour(hour))
            throw new IllegalArgumentException();
        this.hour = hour;
    }

    private static boolean validHour(int hour){
        return hour <=23 && hour >= 0;
    }

    public void setMinutes(int minutes) {
        if(!validMinutes(minutes))
            throw new IllegalArgumentException();
        this.minutes = minutes;
    }

    private static boolean validMinutes(int minutes){
        return minutes < 60 && minutes >= 0;
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

    public boolean isBefore(Time time){
        //godziny mniejsze
        if(this.hour < time.hour) {
            return true;
        }
        //godziny równe, minuty mniejsze
        else if(this.hour == time.hour && this.minutes < time.minutes){
            return true;
        }
        //Wszystko równe
        else if(this.hour == time.hour && this.minutes == time.minutes) {
            return false;
        }
        else{
            return false;
        }
    }

    public boolean isAfter(Time time){
        //godziny większe
        if(this.hour > time.hour) {
            return true;
        }
        //godziny równe, minuty większe
        else if(this.hour == time.hour && this.minutes > time.minutes){
            return true;
        }
        //Wszystko równe
        else if(this.hour == time.hour && this.minutes == time.minutes) {
            return false;
        }
        else{
            return false;
        }
    }
}
