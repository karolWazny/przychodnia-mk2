package com.przychodniamk2.business;

import java.util.Calendar;

public class Date {
    private final int year;
    private final int month;
    private final int day;
    private final Time time;

    public Date(int year, int month, int day, int hour, int minutes){
        this.year = year;
        this.month = month;
        this.day = day;
        this.time = new Time(hour, minutes);
    }

    public static Date today(){
        Calendar calendar = Calendar.getInstance();
        Builder builder = new Builder().withYear(calendar.get(Calendar.YEAR))
                .withMonth(calendar.get(Calendar.MONTH) + 1)
                .withDay(calendar.get(Calendar.DAY_OF_MONTH))
                .withTime(Time.now());
        return builder.build();
    }

    public String dateString(){
        return "" + day + "." + month + "." + year;
    }

    @Override
    public String toString(){
        return dateString() + " " + time;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return time.getHour();
    }

    public int getMinutes() {
        return time.getMinutes();
    }

    public static class ValueOutOfRangeException extends Exception{

    }

    public static class Builder{

        private int year = 1970;
        private int month = 0;
        private int day = 1;
        private int hour = 0;
        private int minutes = 0;

        public Builder(){

        }

        public Date build(){
            return new Date(year, month, day, hour, minutes);
        }

        public Builder withYear(int year){
            this.year = year;
            return this;
        }

        public Builder withMonth(int month){
            this.month = month;
            return this;
        }

        public Builder withDay(int day){
            this.day = day;
            return this;
        }

        public Builder withTime(Time time){
            hour = time.getHour();
            minutes = time.getMinutes();
            return this;
        }
    }
}