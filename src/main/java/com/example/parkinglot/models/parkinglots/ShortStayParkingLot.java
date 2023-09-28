package com.example.parkinglot.models.parkinglots;

import com.example.parkinglot.models.Ticket;
import com.example.parkinglot.models.TimeSpan;

public class ShortStayParkingLot implements IParkingLot {

    private final double MINUTE_RATE = 0.10;
    private final double HOURLY_RATE = 6;
    private final int MAXIMUM_DAILY_RATE = 36;

    @Override
    public long calculateFee(Ticket ticket) {
        double fee = 0;
        TimeSpan duration = ticket.duration;

        //Checking if hours is more than 3.
        if(duration.hours>6){
            duration.days++;
            duration.hours=0;
        }
        fee = duration.hours*HOURLY_RATE + duration.days * MAXIMUM_DAILY_RATE + duration.minutes * MINUTE_RATE;
        fee = Math.ceil(fee);

        return (long) fee;
    }
}
