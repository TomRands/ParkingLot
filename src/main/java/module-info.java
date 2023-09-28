module com.example.parkinglot {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.parkinglot to javafx.fxml;
    exports com.example.parkinglot;
    exports com.example.parkinglot.controller;
    opens com.example.parkinglot.controller to javafx.fxml;
}