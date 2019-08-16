package com.mphasis.car.bo;
import java.util.List;
import com.mphasis.car.entities.Payment;
public interface PaymentBo
{
	public void addPayment(Payment payment);
	 public void deletePayment(String id);
	 public void updatePayment(Payment payment);
	 public List<Payment> getPayments();
	 public Payment getPaymentById(String id);
}
