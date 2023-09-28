package com.example.parkinglot.controller;

import com.example.parkinglot.models.ParkingLot;
import com.example.parkinglot.models.Ticket;
import com.example.parkinglot.view.ParkingLotAppView;
import javafx.stage.Stage;

public class ParkingLotAppController {

    private ParkingLotAppView ui = new ParkingLotAppView(this);
    private ParkingLot parkingLot = new ParkingLot();

    public void runApp(Stage stage) {
        ui.openUI(stage);
    }

    public void displayFee() {
        String timeIn = ui.getTimeIn();
        String timeOut = ui.getTimeOut();
        Ticket ticket = new Ticket();
        ticket.calculateDuration(timeIn, timeOut);
        long fee = parkingLot.calculateFee(ticket);
        ui.displayFee(fee);
    }


}