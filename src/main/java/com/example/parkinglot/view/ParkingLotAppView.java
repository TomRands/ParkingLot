package com.example.parkinglot.view;

import com.example.parkinglot.controller.ParkingLotAppController;
import com.example.parkinglot.models.Ticket;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDateTime;

public class ParkingLotAppView {
    Stage stage;
    private ParkingLotAppController controller;
    private TextField txtFieldTimeIn, txtFieldTimeOut;
    private Button btnCalculateFee;
    private Label resultLbl,timeInLbl, timeOutLbl;

    public ParkingLotAppView(ParkingLotAppController controller) {
        this.controller = controller;
    }

    public void openUI(Stage stage) {
        createUIElements();
        setUpWindowLayout(stage);
        setUpButtonEvent();
    }

    private void setUpWindowLayout(Stage stage) {
        VBox vBox = new VBox(10,timeInLbl, txtFieldTimeIn, timeOutLbl, txtFieldTimeOut, btnCalculateFee, resultLbl);
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox, 300, 300);
        stage.setTitle("Really cool parking meter");
        stage.setScene(scene);
        stage.show();
    }

    private void createUIElements(){
        timeInLbl = new Label("What date and time did you enter?");
        txtFieldTimeIn = new TextField();
        txtFieldTimeIn.setMaxWidth(150);
        txtFieldTimeIn.setPromptText("yyyy-MM-dd HH:mm:ss");
        txtFieldTimeIn.setFocusTraversable(false);

        timeOutLbl = new Label("What date and time are you leaving?");
        txtFieldTimeOut = new TextField();
        txtFieldTimeOut.setMaxWidth(150);
        txtFieldTimeOut.setPromptText("yyyy-MM-dd HH:mm:ss");
        txtFieldTimeOut.setFocusTraversable(false);


        btnCalculateFee = new Button("Calculate fee");
        btnCalculateFee.setFocusTraversable(false);
        resultLbl = new Label("Your total ticket fee is: ");
    }

    private void setUpButtonEvent() {
        btnCalculateFee.setOnAction(e-> controller.displayFee());
    }

    public String getTimeIn() {
        return txtFieldTimeIn.getText();
    }

    public String getTimeOut() {
        return txtFieldTimeOut.getText();
    }

    public void displayFee(long fee) {
        resultLbl.setText("Your total ticket fee is: " + fee);
    }

    public int getParkingLotNumber() {
        return 0;
    }
}
