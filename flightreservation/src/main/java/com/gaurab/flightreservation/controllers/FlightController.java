package com.gaurab.flightreservation.controllers;

import java.util.Date;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gaurab.flightreservation.entity.Flight;
import com.gaurab.flightreservation.repos.FlightRepository;

@Controller
public class FlightController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);
	@Autowired
	private FlightRepository flightRepository;
	
	@PostMapping(value="/searchFlights")
	public String searchFlights
	       (
			@RequestParam("departureCity") String from ,
			@RequestParam("arrivalCity") String to,
			@RequestParam("dateOfDeparture")
			@DateTimeFormat (pattern="yyyy-MM-dd")
			Date departureDate,
			Model model
			) 
	{
		LOGGER.info("Inside findFlights() ::"+"from"+from+"to"+to+"departure"+departureDate);
		List<Flight> flights =
				flightRepository.findFlights(from, to ,departureDate);
		LOGGER.info("Flights found're::"+flights);
		model.addAttribute("flights", flights);
		return "findFlights";
	}
	
	@RequestMapping("/admin/showAddFlight")
	public String showAddFlight() {
		return "addFlight";

	}
	
	


}
