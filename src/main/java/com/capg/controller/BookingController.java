package com.capg.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.Booking;
import com.capg.entity.Bookingdetails;
import com.capg.exception.BookingNotFoundException;
import com.capg.exception.UserNotFoundException;
import com.capg.service.BookingService;

@RestController
@RequestMapping("/seatbooking-bookings")
public class BookingController {

	@Autowired
	BookingService bookingService;

	@PostMapping("/addbooking")
	public String addBooking(@RequestBody Booking booking)
	{
		return bookingService.addBooking(booking);
	}
	@GetMapping("/listAllBookingsByUserId/{uemail_Id}")
	public List<Booking> listAllBookingsByUserId(@PathVariable String uemail_Id) throws UserNotFoundException{
		return bookingService.listAllBookingsByUserId(uemail_Id);
	}

	@GetMapping("/listAllBookingsInDateRange/{startDate}/{endDate}")
	public List<Booking> listAllBookingsInDateRange(@RequestParam("startDate") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)LocalDate startDate,@RequestParam("endDate")@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)LocalDate endDate) throws BookingNotFoundException{
		return bookingService.listAllBookingsInDateRange(startDate, endDate);
	}
	
	@GetMapping("/getBookingbyId/{bookingId}")
	public Booking getBookingbyId(@PathVariable int bookingId) throws BookingNotFoundException{
		return bookingService.getBookingbyId(bookingId);
	}
	
	@DeleteMapping("/deleteBooking/{bookingId}")
	public Booking deleteBooking(@PathVariable int bookingId) throws BookingNotFoundException{
		return bookingService.deleteBooking(bookingId);
	}

}
