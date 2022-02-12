package com.gaurab.flightreservation.controllers;

import java.util.List;


import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gaurab.flightreservation.entity.User;
import com.gaurab.flightreservation.repos.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	//@Autowired
	//private BCryptPasswordEncoder encoder;
	
	// localhost:9091/register
	@GetMapping(value = "/register")
	public String showRegister() {
		
		LOGGER.info("Inside showRegister()::");
		return "register";
	}

	@PostMapping(value = "/registerUser")
	public String registerUser(User user, @RequestParam("cpassword") String confrimPassword, Model model) {
       LOGGER.info("Inside the Register User method::" + "password"+confrimPassword);
		if (user.getPassword().equals(confrimPassword)) {
			// user.setPassword(encoder.encode(user.getPassword()));
			LOGGER.info("Registered user password is::"+user.getPassword());
			userRepository.save(user);
			return "login";
		} else {
			model.addAttribute("errorMessage", "Passwords doesnot matched...");
			return "register";
		}
	}

	@GetMapping(value = "/login")
	public String showLogin() {
		LOGGER.info("Inside the showLogin() :::");
		return "login";
	}

	@PostMapping(value = "/savelLogin")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
		
		LOGGER.info("login()::"+ email + "pssword is:"+ password); 
		if (email.equals("") || password.equals("")) {
			model.addAttribute("errorMessage", "Please input Email and password.. ");
			return "login";
		}

		User user = userRepository.findByEmail(email);
		System.out.println(user);

		// remember if the user is null the it throws null pointer exception when
		// we use user.getPassowrd()
		if (user != null) {
			if (user.getPassword().equals(password)) {
				return "findFlights";
			} else {
				model.addAttribute("errorMessage", "Password doesnot matched");
				return "login";
			}
		}
		// when user is null!!!!
		model.addAttribute("errorMessage", "Email not found ");
		return "login";

	}

}
