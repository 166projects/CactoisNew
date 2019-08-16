
package com.mphasis.car.dao;

import java.util.List;

 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.car.entities.Booking;
 
 
@Repository
 
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
		Transaction tr=session.beginTransaction();
		System.out.println("dao called "+booking.getSource());
		session.save(booking); 
		tr.commit();
        session.close();
		
	}

	public void deleteBooking(String id)
	{
		Session  session = sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Booking booking = (Booking)session.get(Booking.class,id);
		session.delete(booking);
		tr.commit();

		session.close();
	}

	public void updateBooking(Booking booking)
	{
		Session  session = sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(booking);
		tr.commit();

		session.close(); 
	}

	public List<Booking> getBookings() {
		 
		Session  session = sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		List<Booking>  bookings = session.createCriteria(Booking.class).list();
		tr.commit();

		session.close();
		return  bookings; 
	}

	public Booking getBookingById(String id) {
		 
		Session  session = sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Booking booking = (Booking)session.get(Booking.class,id);
		session.save(booking);
		tr.commit();
 
		session.close();
		return booking;
	}

	 
    
}
