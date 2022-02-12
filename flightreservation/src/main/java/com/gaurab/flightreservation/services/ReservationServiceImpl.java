package com.gaurab.flightreservation.services;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaurab.flightreservation.dto.ReservationRequest;
import com.gaurab.flightreservation.entity.Flight;
import com.gaurab.flightreservation.entity.Passenger;
import com.gaurab.flightreservation.entity.Reservation;
import com.gaurab.flightreservation.repos.FlightRepository;
import com.gaurab.flightreservation.repos.PassengerRepository;
import com.gaurab.flightreservation.repos.ReservationRepository;
import com.gaurab.flightreservation.util.EmailUtilImpl;
import com.gaurab.flightreservation.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	PDFGenerator pdfGenerator;

	@Autowired
	EmailUtilImpl emailUtil;

	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private PassengerRepository passengerRepository;

	@Autowired
	private ReservationRepository reservationRepository;

	
	private static final Logger logger = LoggerFactory.getLogger(ReservationServiceImpl.class);
	
	@Override
	public Reservation bookFlight(ReservationRequest request) {
		/// Make Payment

		// Accessing flight id via CompleteReservation.jsp file and
		// accessing all the flight details...
		System.out.println("FLight id:::" + request.getFlightId());
		Long flightId = request.getFlightId();
		Flight flight = flightRepository.findById(flightId).orElseThrow(() -> new EntityNotFoundException());

		// accessing the information input by user and storing it in
		// the database by setting the respective values...\
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setMiddleName(request.getPassengerMiddleName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());
		// .save() method returns the object in the SpringData..
		Passenger savedPassenger = passengerRepository.save(passenger);
		logger.info("Passenger id is::"+savedPassenger.getId());
		System.out.println("Passsenger id is::::" + savedPassenger.getId());
		
		
		// storing the passenger info and flight info in the reservation entity	
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		Reservation savedReservation = reservationRepository.save(reservation);
		// System.out.println("reservation id is::"+ savedReservation.getId());
		
		
		String filePath = "C:/Users/gaura/OneDrive/Desktop/reservation" + savedReservation.getId() + ".pdf";
		pdfGenerator.generateItinerary(savedReservation, filePath);
         System.out.println("----Pdf file genereated......----");
         
		String email = reservation.getPassenger().getEmail();
		emailUtil.sendEmail(email,"Flight information ",filePath);

		return savedReservation;
	}

}
