package com.example.parkinglot.models.parkinglots;

import com.example.parkinglot.models.Ticket;

public interface IParkingLot {
    long calculateFee(Ticket ticket);
}
