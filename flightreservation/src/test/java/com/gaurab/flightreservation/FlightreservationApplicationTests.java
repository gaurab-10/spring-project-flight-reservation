package com.gaurab.flightreservation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gaurab.flightreservation.repos.PassengerRepository;

@SpringBootTest
class FlightreservationApplicationTests {

	@Autowired
	private PassengerRepository repos;
	@Test
	void contextLoads() {
		repos.findById(4L);
	}

}
