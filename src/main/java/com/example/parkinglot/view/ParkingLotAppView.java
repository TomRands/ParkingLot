package com.example.parkinglot.view;

import com.example.parkinglot.controller.ParkingLotAppController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ParkingLotAppView {
    Stage stage;
    private ParkingLotAppController controller;
    private TextField txtFieldTimeIn, txtFieldTimeOut;
    private Button btnCalculateFee;
    private Label resultLbl, timeInLbl, timeOutLbl;
    private RadioButton rdioBtn1, rdioBtn2, rdioBtn3, rdioBtn4;
    ToggleGroup group = new ToggleGroup();
    DatePicker datePickerIn = new DatePicker();
    DatePicker datePickerOut = new DatePicker();
    TilePane tilePaneIn = new TilePane();
    TilePane tilePaneOut = new TilePane();

    public ParkingLotAppView(ParkingLotAppController controller) {
        this.controller = controller;
    }

    public void openUI(Stage stage) {
        createUIElements();
        setUpWindowLayout(stage);
        setUpButtonEvent();
    }

    private void setUpWindowLayout(Stage stage) {
        VBox vBox = new VBox(10,timeInLbl, tilePaneIn, txtFieldTimeIn, timeOutLbl, tilePaneOut, txtFieldTimeOut, btnCalculateFee, resultLbl, rdioBtn1, rdioBtn2, rdioBtn3, rdioBtn4);
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
        txtFieldTimeIn.setPromptText("HH:mm:ss");
        txtFieldTimeIn.setFocusTraversable(false);

        timeOutLbl = new Label("What date and time are you leaving?");
        txtFieldTimeOut = new TextField();
        txtFieldTimeOut.setMaxWidth(150);
        txtFieldTimeOut.setPromptText("HH:mm:ss");
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

        tilePaneIn.setAlignment(Pos.CENTER);
        datePickerIn.setPromptText("dd/MM/yyyy");
        datePickerIn.setFocusTraversable(false);
        formatDatePicker(datePickerIn);
        tilePaneIn.getChildren().add(datePickerIn);

        tilePaneOut.setAlignment(Pos.CENTER);
        datePickerOut.setPromptText("dd/MM/yyyy");
        datePickerOut.setFocusTraversable(false);
        formatDatePicker(datePickerOut);
        tilePaneOut.getChildren().add(datePickerOut);
    }

    private void formatDatePicker(DatePicker datePicker) {
        datePicker.setConverter(new StringConverter<LocalDate>() {
            String pattern = "dd/MM/yyyy";
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

            {
                datePicker.setPromptText(pattern.toLowerCase());
            }

            @Override public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        });
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
        return datePickerIn.getEditor().getText() + ", " + txtFieldTimeIn.getText();
    }

    public String getTimeOut() {
        return datePickerOut.getEditor().getText() + ", " + txtFieldTimeOut.getText();
    }

    public void displayFee(long fee) {
        resultLbl.setText("Your total ticket fee is: " + fee);
    }

}
