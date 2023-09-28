package com.example.parkinglot;

import com.example.parkinglot.controller.ParkingLotAppController;
import javafx.application.Application;
import javafx.stage.Stage;

public class ParkingLotApp extends Application {
    @Override
    public void start(Stage stage){
        ParkingLotAppController controller = new ParkingLotAppController();
        controller.runApp(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}