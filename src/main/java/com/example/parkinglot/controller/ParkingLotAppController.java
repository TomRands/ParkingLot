package com.example.parkinglot.controller;

import com.example.parkinglot.models.parkinglots.IParkingLot;
import com.example.parkinglot.models.ParkingLotFactory;
import com.example.parkinglot.models.Ticket;
import com.example.parkinglot.view.ParkingLotAppView;
import javafx.stage.Stage;
import java.time.format.DateTimeParseException;

public class ParkingLotAppController {

    private final ParkingLotAppView ui = new ParkingLotAppView(this);
    private final ParkingLotFactory factory = new ParkingLotFactory();

    public void runApp(Stage stage) {
        ui.openUI(stage);
    }

    public void displayFee() {
        String timeIn = ui.getTimeIn();
        String timeOut = ui.getTimeOut();
        int parkingLotNumber = ui.getParkingLotNumber();

        Ticket ticket = new Ticket();
        try {
            ticket.calculateDuration(timeIn, timeOut);

            IParkingLot parkingLot = factory.generateParkingLot(parkingLotNumber);
            long fee = parkingLot.calculateFee(ticket);
            if (fee < 0) {
                ui.displayError("Time out must be after time in.");
            }
            else {
                ui.displayFee(fee);
            }
        }
        catch (DateTimeParseException ex) {
            ui.displayError("Invalid input format. Try again");
        }
    }


}