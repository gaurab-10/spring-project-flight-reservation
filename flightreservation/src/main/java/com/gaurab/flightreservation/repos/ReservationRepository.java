package com.gaurab.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gaurab.flightreservation.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
