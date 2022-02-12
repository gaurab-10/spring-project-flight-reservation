package com.gaurab.flightreservation.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User extends AbstractEntity {

	// @Column(name = "FIRST_NAME")
	private String firstName;

	// @Column(name = "LAST_NAME")
	private String lastName;

	// @Column(name = "EMAIL")
	private String email;

	// @Column(name = "PASSWORD")
	private String password;
	
	
//	@ManyToMany
//	// we are telling that from the user table
//	// user_id is used to join and from the otherside
//	// role_id is used to join the columns
//	@JoinTable(name = "user_role",
//			// name should matched the exact column name in database
//			joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
//	private Set<Role> roles;
//
//	public Set<Role> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(Set<Role> roles) {
//		this.roles = roles;
//	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password
				+ "]";
	}

}
