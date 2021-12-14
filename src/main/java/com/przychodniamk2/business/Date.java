package com.przychodniamk2.business;

import java.time.LocalDate;
import java.util.Calendar;

public class Date {
    private final int year;
    private final int month;
    private final int day;

    public Date(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public Date() {
        this(1970, 1, 1);
    }

    public Date(LocalDate value) {
        this.year = value.getYear();
        this.month = value.getMonthValue();
        this.day = value.getDayOfMonth();
    }

    public static Date today(){
        Calendar calendar = Calendar.getInstance();
        Builder builder = new Builder().withYear(calendar.get(Calendar.YEAR))
                .withMonth(calendar.get(Calendar.MONTH) + 1)
                .withDay(calendar.get(Calendar.DAY_OF_MONTH));
        return builder.build();
    }

    public String dateString(){
        return String.format("%02d", day) + "." + String.format("%02d", month) + "." + String.format("%04d", year);
    }

    @Override
    public String toString(){
        return dateString();
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

    public static class ValueOutOfRangeException extends Exception{

    }

    public static class Builder{

        private int year = 1970;
        private int month = 0;
        private int day = 1;

        public Builder(){

        }

        public Date build(){
            return new Date(year, month, day);
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
    }
}