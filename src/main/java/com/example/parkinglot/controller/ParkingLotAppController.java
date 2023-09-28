package com.example.parkinglot.controller;

import com.example.parkinglot.models.IParkingLot;
import com.example.parkinglot.models.ParkingLot;
import com.example.parkinglot.models.ParkingLotFactory;
import com.example.parkinglot.models.Ticket;
import com.example.parkinglot.view.ParkingLotAppView;
import javafx.stage.Stage;

public class ParkingLotAppController {

    private ParkingLotAppView ui = new ParkingLotAppView(this);
    private final ParkingLotFactory factory = new ParkingLotFactory();

    public void runApp(Stage stage) {
        ui.openUI(stage);
    }

    public void displayFee() {
        String timeIn = ui.getTimeIn();
        String timeOut = ui.getTimeOut();
        int parkingLotNumber = ui.getParkingLotNumber();

        Ticket ticket = new Ticket();
        ticket.calculateDuration(timeIn, timeOut);

        IParkingLot parkingLot = factory.generateParkingLot(parkingLotNumber);
        long fee = parkingLot.calculateFee(ticket);
        ui.displayFee(fee);
    }


}