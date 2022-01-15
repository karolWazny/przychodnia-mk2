package com.przychodniamk2.business;

import java.util.LinkedList;
import java.util.List;

public class WorkingHours {
    private Time start;
    private Time end;

    public WorkingHours(Time start, Time end) {
        if(start.isAfter(end) || start.equals(end))
            throw new IllegalArgumentException("Start must happen before the end.");
        this.start = start;
        this.end = end;
    }

    public List<Time> possibleAppointments(){
        List<Time> output = new LinkedList<>();
        int hours = start.getHour();
        int minutes = start.getMinutes();

        while(hours < end.getHour() || (hours == end.getHour() && minutes < end.getMinutes())){
            output.add(new Time(hours, minutes));
            minutes += 30;
            hours += minutes / 60;
            minutes %= 60;
        }
        return output;
    }

    public Time getStart() {
        return start;
    }

    public void setStart(Time start) {
        this.start = start;
    }

    public Time getEnd() {
        return end;
    }

    public void setEnd(Time end) {
        this.end = end;
    }
}
