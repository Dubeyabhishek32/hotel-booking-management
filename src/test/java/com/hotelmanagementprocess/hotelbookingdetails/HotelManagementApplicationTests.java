package com.hotelmanagementprocess.hotelbookingdetails;

import com.hotelmanagementprocess.HotelManagementApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HotelManagementApplicationTests.class)
class HotelManagementApplicationTests {

	@Test
	public static void main(String[] args) {
		SpringApplication.run(HotelManagementApplicationTests.class, args);

	}

}
