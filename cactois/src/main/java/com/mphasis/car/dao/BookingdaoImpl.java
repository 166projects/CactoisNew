package com.mphasis.car.dao;

import java.util.List;

 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mphasis.car.entities.Booking;
 
 
@Repository
@Transactional
public class BookingdaoImpl implements Bookingdao
{   
	@Autowired 
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addBooking(Booking booking) 
	{
		Session  session = sessionFactory.openSession();
		 
		session.save(booking); 
		 
   	    session.close();
		
	}

	public void deleteBooking(String id)
	{
		Session  session = sessionFactory.openSession();
		 
		Booking booking = (Booking)session.get(Booking.class,id);
		session.delete(booking);
		 
		session.close();
	}

	public void updateBooking(Booking booking)
	{
		Session  session = sessionFactory.openSession();
		session.update(booking);
		session.close(); 
	}

	public List<Booking> getBookings() {
		 
		Session  session = sessionFactory.openSession();
		List<Booking>  bookings = session.createCriteria(Booking.class).list();
		session.close();
		return  bookings; 
	}

	public Booking getBookingById(String id) {
		 
		Session  session = sessionFactory.openSession();
		 
		Booking booking = (Booking)session.get(Booking.class,id);
		session.save(booking);
		 
		session.close();
		return booking;
	}

	 
    
}
