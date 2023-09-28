package com.example.parkinglot.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Ticket {

    public TimeSpan duration;

    public void calculateDuration(String stringTimeIn, String stringTimeOut) {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime timeIn = LocalDateTime.parse(stringTimeIn,formatter);
        LocalDateTime timeOut = LocalDateTime.parse(stringTimeOut,formatter);

        long seconds = ChronoUnit.SECONDS.between(timeIn, timeOut);
        long minutes = seconds / 60;
        seconds = seconds % 60;

        long hours = minutes / 60;
        minutes = minutes % 60;

        long days = hours / 24;
        hours = hours % 24;

        duration = new TimeSpan(days, hours, minutes, seconds);
    }




}
