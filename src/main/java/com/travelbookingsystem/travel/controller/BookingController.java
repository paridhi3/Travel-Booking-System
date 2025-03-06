//package com.travelbookingsystem.travel.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.travelbookingsystem.travel.model.Booking;
//import com.travelbookingsystem.travel.service.BookingService;
//
//@RestController
//public class BookingController {
//	
//	@Autowired
//	private BookingService bookingService;
//	
//	
//	@GetMapping("/allBookings")
//	public List<Booking> findAll(){
//		return bookingService.getAllBookings();
//	}
//	
//	@PostMapping("/bookFlight")
//	public Booking bookFlight(@RequestBody Booking booking) {	
//		return bookingService.addBooking(booking);
//	}
//	
//	@GetMapping("/booking/{id}")
//	public Booking getBookingById(@PathVariable long id) {
//		System.out.println("id"+id);
//		return bookingService.getBookingById(id);
//	}
//	
//	
//
//}
