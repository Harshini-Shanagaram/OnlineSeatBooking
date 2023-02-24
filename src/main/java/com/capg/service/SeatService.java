package com.capg.service;

import java.util.List;

import com.capg.entity.Seat;
import com.capg.exception.SeatNotFoundException;

public interface SeatService {
	
	public String addSeats(Seat seat);
	public List<Seat> listAllSeats() throws SeatNotFoundException;
	public Seat getSeatsBySeatNumber(String seatNumber) throws SeatNotFoundException;
	public Seat updateSeats(Seat seat)throws SeatNotFoundException;
	public Seat deleteSeats(String seatNumber) throws SeatNotFoundException;
	public Seat findBySeatFloor(int seatFloor) throws SeatNotFoundException;
	public List<Seat> findBySeatLocation(String seatLocation) throws SeatNotFoundException;
	public Seat bookSeat(int seatId) throws SeatNotFoundException;
	public Seat cancelBooking(int seatId) throws SeatNotFoundException;
}
