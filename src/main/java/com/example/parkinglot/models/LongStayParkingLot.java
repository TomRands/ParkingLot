package com.example.parkinglot.models;

public class LongStayParkingLot implements IParkingLot{

    private final int BASE_DAILY_FEE_RATE = 20;

    private final int BASE_7_DAY_FEE_RATE = 100;

    private final int BASE_30_DAY_FEE_RATE = 350;


    @Override
    public long calculateFee(Ticket ticket) {
        TimeSpan duration = ticket.duration;
        long days = duration.days;
        long fee = 0;

        if (duration.hours != 0 || duration.minutes != 0 || duration.seconds != 0) {
            days++;
        }

        while (days > 0) {
            if (days >= 30) {
                fee += BASE_30_DAY_FEE_RATE;
                days -= 30;
            }
            else if (days >= 7) {
                fee += BASE_7_DAY_FEE_RATE;
                days -= 7;
            }
            else {
                fee += BASE_DAILY_FEE_RATE;
                days--;
            }
        }

        return fee;
    }
}
