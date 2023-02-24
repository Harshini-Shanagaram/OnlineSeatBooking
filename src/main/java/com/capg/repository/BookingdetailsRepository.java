package com.capg.repository;

import java.sql.Date;

//import java.util.Date;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.entity.Bookingdetails;
@Repository
public interface BookingdetailsRepository extends JpaRepository<Bookingdetails,Integer>{



}
