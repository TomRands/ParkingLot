package com.example.parkinglot.models;

public class ParkingLotFactory {

    public IParkingLot generateParkingLot(int number) {
        switch (number) {
            case 1 : return new ParkingLot();
            case 2 : return new ParkingLot();
            default : return  new ParkingLot();
        }
    }

}
