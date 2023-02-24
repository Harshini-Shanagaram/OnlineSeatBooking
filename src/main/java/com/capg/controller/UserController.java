package com.capg.controller;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capg.dto.LoginRequest;
import com.capg.entity.Booking;
import com.capg.entity.User;
import com.capg.exception.BookingNotFoundException;
import com.capg.exception.UserNotFoundException;
import com.capg.service.BookingService;
import com.capg.service.UserService;
@RestController
@RequestMapping("/seatbooking-users")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/userService")
	public String userService(@RequestBody User user) {
		return userService.addUser(user);
	}
	
//	@GetMapping("/loginUser/{emailId}/{password}")
//	public String loginUser(@PathVariable String emailId,@PathVariable String password)throws UserNotFoundException{
//		return userService.loginUser(emailId, password);
//	}
	@PostMapping("/loginUser")
	public String loginUser(@RequestBody LoginRequest request)throws UserNotFoundException{
		return userService.loginUser(request.getEmail(), request.getPassword());
	}
	
	@GetMapping("/findByUserEmailId/{emailId}")
	public User findByUserEmailId(@PathVariable String emailId)throws UserNotFoundException{
		return userService.findByUserEmailId(emailId);
	}
	
	@GetMapping("/isAdmin/{emailId}")
	public boolean isAdmin(@PathVariable String emailId) {
		return userService.isAdmin(emailId);
	}
	
	@GetMapping("/validateSecurityAnswer/{emailId}/{securityAnswer}")
	public boolean validateSecurityAnswer(@PathVariable String emailId,@PathVariable String securityAnswer) {
		return userService.validateSecurityAnswer(emailId, securityAnswer);
	}
	
	@PutMapping("/resetPassword/{emailId}/{password}")
	public String resetPassword(@PathVariable String emailId,@PathVariable String password) {
		return userService.resetPassword(emailId, password);
	}
	
	@DeleteMapping("/deleteUserByEmailId/{emailId}/{password}")
	public String deleteUserByEmailId(@PathVariable String emailId,@PathVariable String password) {
		return userService.deleteUserByEmailId(emailId, password);
	}
	
//	@PutMapping("/updateUserByEmailId/{emailId}/{password}")
//	public String updateUserByEmailId(@PathVariable String emailId,@PathVariable String password) throws UserNotFoundException{
//		return userService.updateUserByEmailId(emailId, password);
//	}
		
//	@PostMapping("/save")
//	public void save(@RequestBody User users) {
//		userService.save(users);
//	}
	
	@PutMapping("/swapBookings/{bookingId1}/{bookingId2}")
	public boolean swapBookings(int bookingId1, int bookingId2) throws BookingNotFoundException{
		return userService.swapBookings(bookingId1, bookingId2);
	}
}
