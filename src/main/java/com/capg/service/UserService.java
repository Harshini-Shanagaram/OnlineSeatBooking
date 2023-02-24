package com.capg.service;
import org.springframework.http.ResponseEntity;

import com.capg.entity.User;
import com.capg.exception.BookingNotFoundException;
import com.capg.exception.UserNotFoundException;

public interface UserService {

	public String addUser(User user);
	public String loginUser(String emailId,String password)throws UserNotFoundException;
	public User findByUserEmailId(String emailId)throws UserNotFoundException;
	public boolean isAdmin(String emailId);
	public boolean validateSecurityAnswer(String emailId,String securityAnswer);
	public String resetPassword(String emailId,String password);
	public String deleteUserByEmailId(String emailId,String password);
//	public String updateUserByEmailId(String emailId,String password) throws UserNotFoundException;
	
//	public void save(User users);
	public boolean swapBookings(int bookingId1, int bookingId2) throws BookingNotFoundException;
}
