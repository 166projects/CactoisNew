//Peri Rashmi
package com.mphasis.car.dao;

import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.car.entities.Driver;
@Repository

public class DriverDaoImpl implements DriverDao {
@Autowired
SessionFactory sessionFactory;
	public Driver getDriverById(String id) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Driver dr=(Driver) session.get(Driver.class, id);
		tr.commit();
		session.close();
		return dr;
	}

	public List<Driver> getDrivers() {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		List<Driver> driver=session.createCriteria(Driver.class).list();
		
		tr.commit();
		session.close();
		return driver;
	}

/*	public void insertDriver(Driver driver) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(driver);
		tr.commit();
		session.close();
	}*/

	public void updateDriver(Driver driver) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(driver);
		tr.commit();
		session.close();
	}

	public void deleteDriver(String id) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.delete(id);
		tr.commit();
		session.close();
	}

	public Driver login(String demail, String pass) {
        Session session=sessionFactory.openSession();
        Transaction tr=session.beginTransaction();
        
        Query query=session.createQuery("from cabDriver where demail=:demail  and dpass=:dpass");
        query.setString("demail", demail);
        query.setString("dpass", pass);
        Driver driver=(Driver) query.uniqueResult();
        tr.commit();
        System.out.println(driver);
        session.close();
        return driver;
 }

 public void changepassword(String did,String oldpass, String newpass) {
 Session session=sessionFactory.openSession();
 Transaction tr=session.beginTransaction();
 Driver driver=(Driver) session.get(Driver.class,did);
 driver.setDpass(newpass);
 session.update(driver);
 tr.commit();
 session.close();
 

 }


	public void signup(Driver driver) {
		Session session=sessionFactory.openSession();
		Transaction  tr=session.beginTransaction();
		session.save(driver);
		tr.commit();
		session.close();
		
	}

}
