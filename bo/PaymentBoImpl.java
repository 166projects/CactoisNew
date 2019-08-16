package com.mphasis.car.bo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mphasis.car.dao.PaymentDao;
import com.mphasis.car.entities.Payment;
@Service
public class PaymentBoImpl implements PaymentBo 
{
	@Autowired
	PaymentDao paymentDao;
	public void addPayment(Payment payment) 
	{
		paymentDao.addPayment(payment);
	}
    public void deletePayment(String id) 
	{
		 paymentDao.deletePayment(id);
	}
    public void updatePayment(Payment payment) 
	{
		paymentDao.updatePayment(payment);
	}
    public List<Payment> getPayments() 
	{
		 return  paymentDao.getPayments();
	}
    public Payment getPaymentById(String id) 
	{
		 return  paymentDao.getPaymentById(id);
	}
}