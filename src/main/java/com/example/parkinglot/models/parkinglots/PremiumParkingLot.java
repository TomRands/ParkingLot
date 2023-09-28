package com.example.parkinglot.models.parkinglots;

import com.example.parkinglot.models.Ticket;
import com.example.parkinglot.models.TimeSpan;

public class PremiumParkingLot implements IParkingLot{

    private final int HOURLY_RATE = 4;
    private final int MAXIMUM_DAILY_RATE = 24;
    @Override
    public long calculateFee(Ticket ticket) {
        long fee = 0;
        TimeSpan duration = ticket.duration;

        //Leave within first 30min it is free
        if (duration.days == 0 && duration.hours == 0 && duration.minutes <= 30) {
            return 0;
        }

        //Round up minutes
        if (duration.minutes != 0) {
            duration.hours++;
        }

        fee += duration.days * MAXIMUM_DAILY_RATE;

        //maximum fee for the day calculation
        long lastDayFee = duration.hours * HOURLY_RATE;
        if (lastDayFee > 15) {
            lastDayFee = 15;
        }
        fee += lastDayFee;

        return fee;

    }
}
