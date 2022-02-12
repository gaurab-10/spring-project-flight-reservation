package com.gaurab.flightreservation.services;

import org.springframework.stereotype.Service;

import com.gaurab.flightreservation.dto.ReservationRequest;
import com.gaurab.flightreservation.entity.Reservation;

@Service
public interface ReservationService {
public Reservation bookFlight(ReservationRequest request);
}
