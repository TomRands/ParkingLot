package com.example.parkinglot.models;

public class ShortStayParkingLot implements IParkingLot{

    private final double MINUTE_RATE = 0.10;
    private final int MAXIMUM_DAILY_RATE = 18;
    @Override
    public long calculateFee(Ticket ticket) {
        double fee = 0;
        TimeSpan duration = ticket.duration;

        fee = duration.minutes * MINUTE_RATE;

        //Maximum Daily Rate for Short Stays is 18 and anything over 3 hours is counted as Days.
        if(duration.minutes > 180) {
            duration.days++;
            fee = duration.days * MAXIMUM_DAILY_RATE;
        }

        fee = Math.ceil(fee);

        return (long) fee;

    }
}
