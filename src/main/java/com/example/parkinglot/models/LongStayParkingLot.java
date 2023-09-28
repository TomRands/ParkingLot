package com.example.parkinglot.models;

public class LongStayParkingLot implements IParkingLot{
    @Override
    public long calculateFee(Ticket ticket) {
        return 0;
    }
}
