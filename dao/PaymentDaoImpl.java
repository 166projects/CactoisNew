package com.mphasis.car.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mphasis.car.entities.Payment;

@Repository
public class PaymentDaoImpl implements PaymentDao 
{
	@Autowired
	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}

	public void addPayment(Payment payment) 
	{
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(payment);
		tr.commit();
		session.close();
		
	}

	public void deletePayment(String id) 
	{
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Payment payment=(Payment) session.get(Payment.class,id);
		session.delete(payment);
		tr.commit();
		session.close();
		
	}

	public void updatePayment(Payment payment) 
	{
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(payment);
		tr.commit();
		session.close();
		
	}

	public List<Payment> getPayments() 
	
	{
		Session  session = sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		List<Payment>  payments = session.createCriteria(Payment.class).list();
		tr.commit();
        session.close();
		return  payments; 
	}

	public Payment getPaymentById(String id) 
	{
		Session  session = sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Payment payment=(Payment) session.get(Payment.class,id);
		session.save(payment);
		tr.commit();
        session.close();
		return payment;
	}
	 
}
