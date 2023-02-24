package com.capg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class OnlineSeatBookingSystemApplication {
	@GetMapping("/message")
	public String getMessage() {
	return "Welcome to OnlineSeatBooking";
	}
	public static void main(String[] args) {
		SpringApplication.run(OnlineSeatBookingSystemApplication.class, args);
	}

}


