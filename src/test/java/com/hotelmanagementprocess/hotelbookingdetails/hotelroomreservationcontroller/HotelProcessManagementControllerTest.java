package com.hotelmanagementprocess.hotelbookingdetails.hotelroomreservationcontroller;

import com.hotelmanagementprocess.hotelroomreservationcontroller.HotelProcessManagementController;
import com.hotelmanagementprocess.hotelroomreservationmodel.BookingDto;
import com.hotelmanagementprocess.hotelroomreservationserviceImpl.HotelProcessBookingManager;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;


import java.time.LocalDate;

import java.util.logging.Logger;


import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HotelProcessManagementController.class)
public class HotelProcessManagementControllerTest {
    private static final Logger LOGGER = Logger.getLogger(HotelProcessManagementController.class.getName());

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HotelProcessBookingManager hotelProcessBookingManager;


    @Test
    public void createGuestReservation() throws Exception {
        String guestName = "Abhishek Dubey";
        Integer roomNumber = 2;
        LocalDate date = LocalDate.parse("2024-06-08");
        hotelProcessBookingManager.createHotelBooking(guestName, roomNumber, date);
    }


}