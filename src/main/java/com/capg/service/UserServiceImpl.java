package com.capg.service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.capg.entity.Admin;
import com.capg.entity.Booking;
import com.capg.entity.User;
import com.capg.exception.BookingNotFoundException;
import com.capg.exception.UserNotFoundException;
import com.capg.repository.BookingRepository;
import com.capg.repository.UserRepository;


@Service("UserService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BookingRepository bookingRepository;

	@Override
	public String addUser(User user) {
		userRepository.saveAndFlush(user);
		return "User added successfully";
	}

	@Override
	public String loginUser(String emailId, String password) throws UserNotFoundException {
		User bean = new User();
		try {
			for(User i : userRepository.findAll()) {
				if(i.getEmailId().equals(emailId) && i.getPassword().equals(password)) {
					bean = i;
				}
			}
		}
		catch(Exception e) {
			throw new UserNotFoundException("User details not found!");
		}
		return "Logged in successfully";
	}

	@Override
	public User findByUserEmailId(String emailId) throws UserNotFoundException {
		User bean = new User();
		try {
			for(User i : userRepository.findAll()) {
				if(i.getEmailId().equals(emailId) ) {
					bean = i;
				}
			}
		}
		catch(Exception e) {
			throw new UserNotFoundException("User details not found!");
		}
		return bean;
	}

	@Override
	public boolean isAdmin(String emailId) {
		User bean = new User();
		try {
			for(User i : userRepository.findAll()) {
				if(i.getRole().equals("Admin")) {
					return true;
				}
			}
		}
		catch(Exception e) {
			throw new UserNotFoundException("User details not found!");
		}
		return false;
	}

	@Override
	public boolean validateSecurityAnswer(String emailId, String securityAnswer) {
		User bean = new User();
		try {
			for(User i : userRepository.findAll()) {
				if(i.getEmailId().equals(emailId) && i.getSecurityAnswer().equals(securityAnswer)) {
					return true;
				}
			}
		}
		catch(Exception e) {
			throw new UserNotFoundException("User details not found!");
		}
		return false;
	}

	@Override
	public String resetPassword(String emailId,String password) {
		User bean = new User();
		try {
			for(User i : userRepository.findAll()) {
				if(i.getEmailId().equals(emailId) ) {
					i.setPassword(password);
					bean = i;
				}
			}
		}
		catch(Exception e) {
			throw new UserNotFoundException("User details not found!");
		}
		userRepository.saveAndFlush(bean);
		return "Password reset is successful";
	}

	@Override
	public String deleteUserByEmailId(String emailId, String password) {
		User bean = new User();
		try {
			for(User i : userRepository.findAll()) {
				if(i.getEmailId().equals(emailId) && i.getPassword().equals(password)) {
					bean = i;
				}
			}
		}
		catch(Exception e) {
			throw new UserNotFoundException("User details not found!");
		}
		userRepository.deleteById(bean.getuId());
		return "User deleted successfully";
	}

//	@Override
//	public String updateUserByEmailId(String emailId, String password) throws UserNotFoundException {
//		User bean = new User();
//		try {
//			for(User i : userRepository.findAll()) {
//				if(i.getEmailId().equals(emailId) && i.getPassword().equals(password)) {
//					bean = i;
//				}
//			}
//		}
//		catch(Exception e) {
//			throw new UserNotFoundException("User details not found!");
//		}
//		userRepository.saveAndFlush(bean);
//		return "Updated successfully";
//	}

	

//	@Override
//	public void save(User users) {
//		userRepository.saveAndFlush(users);
//	}

	@Override
	public boolean swapBookings(int bookingId1, int bookingId2)throws BookingNotFoundException {
		Booking bean1 = null;
		Booking bean2 = null;
		try {
			for(Booking i : bookingRepository.findAll()) {
				bean1 = bookingRepository.findById(bookingId1).get();
				bean2 = bookingRepository.findById(bookingId2).get();
			}
		}
		catch(Exception e) {
			throw new BookingNotFoundException("Booking details not found!");
		}
		User temp = bean1.getUser();
		bean1.setUser(bean2.getUser());
		bean2.setUser(temp);
		return true;
	}
	
	




}
