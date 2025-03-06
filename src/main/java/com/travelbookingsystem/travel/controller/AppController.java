package com.travelbookingsystem.travel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	
	@GetMapping("/")
	public String homepage() {
		return "home";
	}

	@GetMapping("/adminLogin")
	public String adminLoginlogin() {
		return "adminLogin";
	}
	
	@GetMapping("/passengerLogin")
	public String passengerLoginlogin() {
		return "passengerLogin";
	}
	
	@GetMapping("/passengerRegistration")
	public String passengerRegister() {
		return "passengerRegistration";
	}
	
	@GetMapping("/bookFlight")
	public String bookFlight() {
		return "bookFlight";
	}
	
	@GetMapping("/bookTrain")
	public String bookTrain() {
		return "bookTrain";
	}
	
	@GetMapping("/bookBus")
	public String bookBus() {
		return "bookBus";
	}
	

}
