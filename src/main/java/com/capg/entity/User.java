package com.capg.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/*
 {
	"emailId" : "zames@gmail.com",
	"password" : "Kiran@123",
	"securityAnswer" : "Whats your pet name?",
	"role" : "SDE"
}

 {
	"emailId" : "RayJones@gmail.com",
	"password" : "Ray@123",
	"securityAnswer" : "Whats your pet name?",
	"role" : "SDE"
}
 */
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity 
@Table(name="Users_detail")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uId;
	
	private String emailId;
	
	private String password;

	private String securityAnswer;
	
	private String role;
	
	@OneToMany(mappedBy = "user" , fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Booking> bookings;

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	
}

