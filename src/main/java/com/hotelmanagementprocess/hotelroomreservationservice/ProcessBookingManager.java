package com.hotelmanagementprocess.hotelroomreservationservice;

import com.hotelmanagementprocess.hotelroomreservationmodel.BookingDto;

import java.time.LocalDate;
import java.util.List;


public interface ProcessBookingManager {

    void createHotelBooking(String guestName, int roomNumber, LocalDate date) throws Exception;
    List<Integer> getAvailableRooms(LocalDate date) throws Exception;
    List<BookingDto> getReservedRoomByGuest(String guestName) throws Exception;

}
