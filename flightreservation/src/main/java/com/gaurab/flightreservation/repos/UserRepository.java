package com.gaurab.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gaurab.flightreservation.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

	
}
