package com.gaurab.flightreservation.controllers;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaurab.flightreservation.dto.ReservationUpdateRequest;
import com.gaurab.flightreservation.entity.Reservation;
import com.gaurab.flightreservation.repos.ReservationRepository;

@RestController
public class ReservationRestController {

	@Autowired
	ReservationRepository reservationRepository;
// yedi get/post/put ma confuse bhaye dheki we can use request mapping.
	@RequestMapping(value = "/reservations/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {

		return reservationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());

	}

	@RequestMapping(value = "/reservations")
	// here request body deseralize the json format to the reservationUpdateRequest variables..
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		
		Reservation reservation = reservationRepository.findById(request.getId())
				.orElseThrow(() -> new EntityNotFoundException());
		reservation.setNoOfBags(request.getNoOfBags());
		reservation.setCheckedIn(request.isCheckedIn());

		return reservationRepository.save(reservation);
	}
}
