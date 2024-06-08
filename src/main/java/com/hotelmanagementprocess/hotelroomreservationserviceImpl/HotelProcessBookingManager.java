package com.hotelmanagementprocess.hotelroomreservationserviceImpl;


import com.hotelmanagementprocess.hotelroomreservationmodel.BookingDto;
import com.hotelmanagementprocess.hotelroomreservationservice.ProcessBookingManager;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class HotelProcessBookingManager implements ProcessBookingManager {

    @Autowired
    BookingDto bookingDto;
    @Value("${total.rooms}")
    private int roomNumbers;
    private Map<Integer, List<BookingDto>> bookingsByRoomReservation;
    private Map<String, List<BookingDto>> bookingsByGuestDetails;

    @PostConstruct
    private void postConstruct() {
        this.bookingsByRoomReservation = new ConcurrentHashMap<>();
        this.bookingsByGuestDetails = new ConcurrentHashMap<>();
        for (int i = 1; i <= roomNumbers; i++) {
            bookingsByRoomReservation.put(i, new ArrayList<>());
        }
    }


    @Override
    public void createHotelBooking(String guestName, int roomNumber, LocalDate date) throws IllegalArgumentException {

        try {
            for (BookingDto bookingDto : bookingsByRoomReservation.get(roomNumber)) {

                if (bookingDto.getDate().equals(date)) {
                    throw new IllegalArgumentException("Room Reservation already exists for room " + roomNumber + " on date " + date);
                }
            }

            bookingDto.setDate(date);
            bookingDto.setGuestName(guestName);
            bookingDto.setRoomNumber(roomNumber);
            bookingsByRoomReservation.get(roomNumber).add(bookingDto);
            bookingsByGuestDetails.computeIfAbsent(guestName, k -> new ArrayList<>()).add(bookingDto);

        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to create the hotel reservation: " + e.getMessage());
        }
    }

    @Override
    public List<BookingDto> getReservedRoomByGuest(String guestName) throws IllegalArgumentException {
        try {
            return bookingsByGuestDetails.getOrDefault(guestName, new ArrayList<>());
        } catch (Exception e) {
            throw new IllegalArgumentException("Oops...Finding an error while making a reservation for the guest: " + e.getMessage());
        }
    }


    @Override
    public List<Integer> getAvailableRooms(LocalDate date) throws IllegalArgumentException {
        List<Integer> availableRooms = new ArrayList<>();

        try {
            for (int i = 1; i <= roomNumbers; i++) {
                boolean isBooked = false;
                for (BookingDto bookingDto : bookingsByRoomReservation.get(i)) {
                    if (bookingDto.getDate().equals(date)) {
                        isBooked = true;
                        break;
                    }
                }
                if (!isBooked) {
                    availableRooms.add(i);
                }
            }

            return availableRooms;

        } catch (Exception e) {
            throw new IllegalArgumentException("Oops...Finding error while searching for the available rooms: " + e.getMessage());
        }
    }


}
