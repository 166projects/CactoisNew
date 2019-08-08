package com.mphasis.car.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.car.dao.Bookingdao;
import com.mphasis.car.entities.Booking;
@Service
public class BookingboImpl implements Bookingbo{
	@Autowired
	Bookingdao bookingdao;
	public void addBooking(Booking booking) {
		   bookingdao.addBooking(booking);
		
	}

	public void deleteBooking(String id) {
		 
		bookingdao.deleteBooking(id);
	}

	public void updateBooking(Booking booking) {
		 bookingdao.updateBooking(booking);
		
	}

	public List<Booking> getBookings() {
		 return bookingdao.getBookings();
	}

	public Booking getBookingById(String id) {
		 
		return  bookingdao.getBookingById(id);
	}

	 

}
