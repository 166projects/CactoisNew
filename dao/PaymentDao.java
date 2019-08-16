package com.mphasis.car.dao;

import java.util.List;
import com.mphasis.car.entities.Payment;

public interface PaymentDao 
{
	 public void addPayment(Payment payment);
	 public void deletePayment(String id);
	 public void updatePayment(Payment payment);
	 public List<Payment> getPayments();
	 public Payment getPaymentById(String id);

}
