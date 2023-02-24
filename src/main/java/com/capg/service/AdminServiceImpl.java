package com.capg.service;
import java.util.regex.Matcher; 
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.capg.entity.Admin;
import com.capg.entity.Booking;
import com.capg.entity.Bookingdetails;
import com.capg.entity.User;
import com.capg.exception.UserNotFoundException;
import com.capg.repository.AdminRepository;
import com.capg.repository.BookingRepository;
import com.capg.repository.BookingdetailsRepository;
import com.capg.repository.UserRepository;



@Service("AdminService")
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	BookingdetailsRepository bookingdetailsRepository;
	
	@Autowired
	UserRepository userRepository;

	public AdminServiceImpl(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}
	@Override
	public String addAdmin(Admin admin) {
		adminRepository.saveAndFlush(admin);
		return "Admin added successfully";
	}

	@Override
	public String loginAdmin(String emailId, String password) throws UserNotFoundException {
		Admin bean = new Admin();
		try {
			for(Admin i : adminRepository.findAll()) {
				if(i.getEmailId().equals(emailId) && i.getPassword().equals(password)) {
					bean = i;
				}
			}
		}
		catch(Exception e) {
			throw new UserNotFoundException("Admin details not found!");
		}
		return "Logged in successfully";
	}

	@Override
	public Admin getAdminByEmailId(String aemailId) throws UserNotFoundException {
		Admin bean = new Admin();
		try {
			for(Admin i : adminRepository.findAll()) {
				if(i.getEmailId().equals(aemailId) ) {
					bean =  i;
				}
			}
		}
		catch(Exception e) {
			throw new UserNotFoundException("Admin details not found!");
		}
		return bean;
	}

	@Override
	public String updateAdmin(Admin adminDetails) throws UserNotFoundException {
		Admin  bean = null;
		try {
			bean = adminRepository.findById(adminDetails.getaId()).get();
		}
		catch(Exception e) {
			throw new UserNotFoundException("Admin details not found!");
		}
		adminRepository.saveAndFlush(adminDetails);
		return "Admin details updated";
	}

	@Override
	public String deleteAdmin(int adminId) throws UserNotFoundException {
		Admin  bean = null;
		try {
			bean = adminRepository.findById(adminId).get();
		}
		catch(Exception e) {
			throw new UserNotFoundException("Admin details not found!");
		}
		adminRepository.deleteById(adminId);
		return "Admin record deleted successfully";
	}

	@Override
	public Admin findByAdminName(String adminName) throws UserNotFoundException {
		Admin bean = new Admin();
		try {
			for(Admin i : adminRepository.findAll()) {
				if(i.getAdminName().equals(adminName) ) {
					bean = i;
				}
			}
		}
		catch(Exception e) {
			throw new UserNotFoundException("Admin details not found!");
		}
		return bean;
	}


	@Override
	public String approveBooking(int bookingId) throws UserNotFoundException {
		Bookingdetails  bean = new Bookingdetails();
		try {
			bean = bookingdetailsRepository.findById(bookingId).get();
		}
		catch(Exception e) {
			throw new UserNotFoundException("Booking details not found!");
		}
		bean.setBookingStatus("Approved");
		bookingdetailsRepository.saveAndFlush(bean);
		return "Booking is approved";
	}

	@Override
	public String rejectBooking(int bookingId) throws UserNotFoundException {
		Bookingdetails  bean = null;
		try {
			bean = bookingdetailsRepository.findById(bookingId).get();
		}
		catch(Exception e) {
			throw new UserNotFoundException("Booking details not found!");
		}
		bean.setBookingStatus("Rejected");
		return "Booking rejected";
	}

	@Override
	public String disallowBooking(int bookingId) throws UserNotFoundException {
		Bookingdetails  bean = null;
		try {
			bean = bookingdetailsRepository.findById(bookingId).get();
		}
		catch(Exception e) {
			throw new UserNotFoundException("Booking details not found!");
		}
		bean.setBookingStatus("Disallowed");
		return "Booking disallowed";
	}

	@Override
	public String approveCancellation(int bookingId) throws UserNotFoundException {
		Bookingdetails  bean = null;
		try {
			bean = bookingdetailsRepository.findById(bookingId).get();
		}
		catch(Exception e) {
			throw new UserNotFoundException("Booking details not found!");
		}
		bean.setBookingStatus("Cancelled");
		return "Cancellation approved";
	}
}
