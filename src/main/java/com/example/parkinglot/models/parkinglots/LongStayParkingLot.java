package com.example.parkinglot.models.parkinglots;

import com.example.parkinglot.models.Ticket;
import com.example.parkinglot.models.TimeSpan;

public class LongStayParkingLot implements IParkingLot{
    private final int BASE_DAILY_FEE_RATE = 18;
    private final int BASE_OVER_5_DAY_FEE_RATE = 10;
    private final int BASE_OVER_10_DAY_FEE_RATE = 8;


    @Override
    public long calculateFee(Ticket ticket) {
        TimeSpan duration = ticket.duration;
        long days = duration.days;
        long fee = 0;

        if (duration.hours != 0 || duration.minutes != 0 || duration.seconds != 0) {
            days++;
        }

        while (days > 0) {
            if (days >= 10) {
                fee += BASE_OVER_10_DAY_FEE_RATE * 10;
                days -= 10;
            }
            else if (days >= 5) {
                fee += BASE_OVER_5_DAY_FEE_RATE * 5;
                days -= 5;
            }
            else {
                fee += BASE_DAILY_FEE_RATE;
                days--;
            }
        }
        return fee;
    }
}
