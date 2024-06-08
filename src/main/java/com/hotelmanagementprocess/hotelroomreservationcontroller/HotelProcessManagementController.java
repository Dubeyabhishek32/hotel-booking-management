package com.hotelmanagementprocess.hotelroomreservationcontroller;

import com.hotelmanagementprocess.hotelroomreservationmodel.BookingDto;
import com.hotelmanagementprocess.hotelroomreservationserviceImpl.HotelProcessBookingManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController

// Class
public class HotelProcessManagementController {
    private static final Logger LOGGER = Logger.getLogger(HotelProcessManagementController.class.getName());

    @Autowired
    HotelProcessBookingManager hotelProcessBookingManager;

    @GetMapping("/hotel-available-rooms")
    public String getAvailableRooms(@RequestParam("date") String date) {

        LOGGER.info("Processing hotel room booking...");
        try {

            LocalDate parsedDate = LocalDate.parse((date));

            // Get the details for all the available rooms for the given date
            List<Integer> availableRooms = hotelProcessBookingManager.getAvailableRooms(parsedDate);

            // Generated the response with available room details
            String response = availableRooms.stream().map(Object::toString).collect(Collectors.joining(","));
            return response;

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Facing errors while processing the room booking", e);

            String errorMessage = "{\"error\": " + e.getMessage() + "}";
            return errorMessage;
        }

    }


    @GetMapping("/reservation-for-guest/{guestName}")
    public List<BookingDto> getRoomByGuest(@PathVariable("guestName") String guestName) {

        List<BookingDto> ReservedRooms = null;

        LOGGER.info("Checking details for the best room for ..." + guestName);
        try {


            // Get the room details which are associated for a given guest
            ReservedRooms = hotelProcessBookingManager.getReservedRoomByGuest(guestName);


            return ReservedRooms;

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Something is going wrong while processing the available room request", e);

            String errorMessage = "{\"error\": " + e.getMessage() + "}";

        }
        return ReservedRooms;
    }


    @PostMapping("/hotel-bookings")
    public String createGuestReservation(String guestName, int roomNumber, String date) {
        try {
            LocalDate parsedDate = LocalDate.parse(date);
            // Create the booking for our valuable Guest
            hotelProcessBookingManager.createHotelBooking(guestName, roomNumber, parsedDate);
            return "{\"message\": \"We are pleased to inform you that your booking is confirmed...Thank you for making a reservation\"}";
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Facing errors while processing the hotel room reservation", e);

            return "{\"error\": " + e.getMessage() + "}";

        }

    }


}
