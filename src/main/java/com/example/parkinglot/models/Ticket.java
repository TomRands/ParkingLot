package com.example.parkinglot.models;

import com.example.parkinglot.controller.ParkingLotAppController;
import com.example.parkinglot.view.ParkingLotAppView;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

public class Ticket {
    public Duration duration;

    public Duration daysDuration, hourDuration, minuteDuration;
    public Period period;

    ParkingLotAppController parkingLotAppController = new ParkingLotAppController();

    public LocalDateTime timeIn, timeOut;

    public int calculateAndSendDuration(String timeIn, String timeout) {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        this.timeIn = LocalDateTime.parse(timeIn,formatter);
        this.timeOut = LocalDateTime.parse(timeout,formatter);
        daysDuration = Duration.ofDays(ChronoUnit.DAYS.between(this.timeIn, timeOut));
        hourDuration = Duration.ofHours(ChronoUnit.HOURS.between(this.timeIn,timeOut));
        minuteDuration = Duration.ofMinutes(ChronoUnit.MINUTES.between(this.timeIn,timeOut));

        return Integer.parseInt(String.valueOf(daysDuration)) + Integer.parseInt(String.valueOf(hourDuration)) + Integer.parseInt(String.valueOf(minuteDuration));
    }




}
