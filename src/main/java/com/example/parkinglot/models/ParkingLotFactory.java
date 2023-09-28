package com.example.parkinglot.models;

import com.example.parkinglot.models.parkinglots.*;

public class ParkingLotFactory {

    public IParkingLot generateParkingLot(int number) {
        return switch (number) {
            case 2 -> new ShortStayParkingLot();
            case 3 -> new LongStayParkingLot();
            case 4 -> new PremiumParkingLot();
            default -> new ParkingLot();
        };
    }

}
