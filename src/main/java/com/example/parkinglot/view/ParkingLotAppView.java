package com.example.parkinglot.view;

import com.example.parkinglot.controller.ParkingLotAppController;
import com.example.parkinglot.models.Ticket;
import javafx.stage.Stage;

import java.time.LocalDateTime;

public class ParkingLotAppView {

    private ParkingLotAppController controller;

    public ParkingLotAppView(ParkingLotAppController controller) {
        this.controller = controller;
    }

    public void openUI(Stage stage) {

    }

    public String getTimeIn() {
        return null;
    }

    public String getTimeOut() {
        return null;
    }

    public void displayFee(int fee) {

    }
}
