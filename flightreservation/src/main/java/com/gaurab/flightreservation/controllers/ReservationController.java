package com.gaurab.flightreservation.controllers;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gaurab.flightreservation.dto.ReservationRequest;
import com.gaurab.flightreservation.entity.Flight;
import com.gaurab.flightreservation.entity.Reservation;
import com.gaurab.flightreservation.repos.FlightRepository;
import com.gaurab.flightreservation.services.ReservationService;
import com.gaurab.flightreservation.util.EmailUtilImpl;

@Controller
public class ReservationController {

	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private ReservationService reservationService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);
	@GetMapping(value = "/showReservation")
	public String showCompleteReservation(@RequestParam("flightID") Long id, ModelMap model) {
		System.out.println("Iam show reservation");
		Flight flight = flightRepository.findById(id).orElseThrow( () -> new EntityNotFoundException() );
		LOGGER.info("Inside the Reservation Controller:: ");
		LOGGER.info("Flight id is::"+id);
		model.addAttribute("flight", flight);
		return "completeReservations";
	}

	@PostMapping(value = "/completeReservation")
	public String completeReservation(ReservationRequest request, ModelMap model) {
		Reservation reservation = reservationService.bookFlight(request);
		model.addAttribute("msg",
				"Reservation created Successsfully" + "Your Reservation id is::" + reservation.getId());
		return "reservationConformation";
	}
	// reservation id can be used by costumer to checked In the flight...

}
