package com.example.parkinglot.models.parkinglots;

import com.example.parkinglot.models.Ticket;
import com.example.parkinglot.models.TimeSpan;

public class ShortStayParkingLot implements IParkingLot{

    private final double MINUTE_RATE = 0.10;
    private final double HOURLY_RATE = 6;
    private final int MAXIMUM_DAILY_RATE = 18;
    @Override
    public long calculateFee(Ticket ticket) {
        double fee=0;
        TimeSpan duration = ticket.duration;

        if(duration.hours == 0) {
            fee = duration.minutes * MINUTE_RATE;
        } else if(duration.hours<=3) {
            fee = (duration.hours * HOURLY_RATE) + duration.minutes * MINUTE_RATE;
        }
        else if(duration.hours > 3) {
            duration.days++;
            fee = duration.days * MAXIMUM_DAILY_RATE;
        }else if (duration.days > 1){
            fee = duration.days * MAXIMUM_DAILY_RATE;
        }
        fee = Math.ceil(fee);

        return (long) fee;

    }
}
