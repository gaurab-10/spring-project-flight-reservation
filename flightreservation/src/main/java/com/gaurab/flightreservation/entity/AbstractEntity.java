package com.gaurab.flightreservation.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

//@MappedSuperclass
/*
 *  This tells that the class is not directly mappped
 *  to the database but it acts as the 
 *  parent class for other entities... 
 */
@MappedSuperclass
public class AbstractEntity { 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
