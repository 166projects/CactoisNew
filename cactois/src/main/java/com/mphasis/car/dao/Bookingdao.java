package com.mphasis.car.dao;

import java.util.List;

import com.mphasis.car.entities.Booking;

public interface Bookingdao 
{
	 public void addBooking(Booking booking);
	 public void deleteBooking(String id);
	 public void updateBooking(Booking booking);
	 public List<Booking> getBookings();
	 public Booking getBookingById(String id);
	  
}
