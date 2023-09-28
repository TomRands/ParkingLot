package com.example.parkinglot.view;

import com.example.parkinglot.controller.ParkingLotAppController;
import com.example.parkinglot.models.Ticket;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDateTime;

public class ParkingLotAppView {
    Stage stage;
    private ParkingLotAppController controller;
    private TextField txtFieldTimeIn, txtFieldTimeOut;
    private Button btnCalculateFee;
    private Label resultLbl, timeInLbl, timeOutLbl;
    private RadioButton rdioBtn1, rdioBtn2, rdioBtn3, rdioBtn4;
    ToggleGroup group = new ToggleGroup();

    public ParkingLotAppView(ParkingLotAppController controller) {
        this.controller = controller;
    }

    public void openUI(Stage stage) {
        createUIElements();
        setUpWindowLayout(stage);
        setUpButtonEvent();
    }

    private void setUpWindowLayout(Stage stage) {
        VBox vBox = new VBox(10,timeInLbl, txtFieldTimeIn, timeOutLbl, txtFieldTimeOut, btnCalculateFee, resultLbl, rdioBtn1, rdioBtn2, rdioBtn3, rdioBtn4);
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox, 400, 400);
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

        rdioBtn1 = new RadioButton("Standard");
        rdioBtn1.setSelected(true);
        rdioBtn2 = new RadioButton("Short-Term");
        rdioBtn3 = new RadioButton("Long-Term");
        rdioBtn4 = new RadioButton("Premium");


        rdioBtn1.setToggleGroup(group);
        rdioBtn2.setToggleGroup(group);
        rdioBtn3.setToggleGroup(group);
        rdioBtn4.setToggleGroup(group);


        btnCalculateFee = new Button("Calculate fee");
        btnCalculateFee.setFocusTraversable(false);
        resultLbl = new Label("Your total ticket fee is: ");
    }

    private void setUpButtonEvent() {
        btnCalculateFee.setOnAction(e-> controller.displayFee());
    }

    public int getParkingLotNumber(){
        Toggle selectedToggle = group.getSelectedToggle();
        if (selectedToggle.equals(rdioBtn1)) {
            return 1;
        } else if (selectedToggle.equals(rdioBtn2)) {
            return 2;
        } else if (selectedToggle.equals(rdioBtn3)) {
            return 3;
        } else if (selectedToggle.equals(rdioBtn4)) {
            return 4;
        }
        return 1;
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

}
