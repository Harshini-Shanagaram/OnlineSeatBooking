package com.capg.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.entity.Booking;
@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {



}
