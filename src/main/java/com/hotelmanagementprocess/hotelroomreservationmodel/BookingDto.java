package com.hotelmanagementprocess.hotelroomreservationmodel;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class BookingDto {

    private String guestName;
    private int roomNumber;
    private LocalDate date;

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
