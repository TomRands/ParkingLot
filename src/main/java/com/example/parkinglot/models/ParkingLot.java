package com.example.parkinglot.models;

import java.time.Duration;

public class ParkingLot {

    private final int HOURLY_RATE = 2;
    private final int MAXIMUM_DAILY_RATE = 15;

    public int calculateFee(Ticket ticket) {
        Duration duration = ticket.duration;
        int minutes = getMinutes(duration);
        int hours = getHours(duration);
        int days = 0;
        int fee = 0;

        while (hours >= 24) {
            hours -= 24;
            days++;
        }

        //Leave within first 30min it is free
        if (days == 0 && hours == 0 && minutes <= 30) {
            return 0;
        }

        //Round up minutes
        if (minutes != 0) {
            hours++;
        }

        fee += days * MAXIMUM_DAILY_RATE;

        //maximum fee for the day calculation
        int lastDayFee = hours * HOURLY_RATE;
        if (lastDayFee > 15) {
            lastDayFee = 15;
        }
        fee += lastDayFee;

        return fee;
    }

    private int getMinutes(Duration duration) {
        try {
            return duration.toMinutesPart();
        }
        catch (NullPointerException ex) {
            return 0;
        }
    }
    private int getHours(Duration duration) {
        try {
            return duration.toHoursPart();
        }
        catch (NullPointerException ex) {
            return 0;
        }
    }
}
