package com.capg.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity 
public class Seat {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seatId;
	
	private String seatNumber;
	
	private String seatLocation;

	private int seatFloor;

	private int floorCapacity;

	private boolean isBooked;
	
	private int seatsAvailable;
	
	private String emailId;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "u_id", referencedColumnName = "uId")
	private User user;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "a_id", referencedColumnName = "aId")
	private Admin admin;	
}
