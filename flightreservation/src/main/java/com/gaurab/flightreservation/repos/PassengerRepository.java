package com.gaurab.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gaurab.flightreservation.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
