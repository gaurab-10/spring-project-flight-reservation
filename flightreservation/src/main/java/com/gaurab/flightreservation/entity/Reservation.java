package com.gaurab.flightreservation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation extends AbstractEntity {

	private boolean checkedIn;
	@Column(name = "number_of_bags")
	private int noOfBags;

	@OneToOne
	// Here since reservation uses the foreign key of the
	// passenger id we are showing the dependency and we are mentioning
	// its relationship with passengerID which is one to one...
	// i.e. Every reservation has one flight and one passenger..
	private Passenger passenger;
	@OneToOne
	private Flight flight;

	public boolean isCheckedIn() {
		return checkedIn;
	}

	public void setCheckedIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}

	public int getNoOfBags() {
		return noOfBags;
	}

	public void setNoOfBags(int noOfBags) {
		this.noOfBags = noOfBags;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	// CREATED
	// private TimeStamp created;

}
