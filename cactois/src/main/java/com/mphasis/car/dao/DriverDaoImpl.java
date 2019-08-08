//Peri Rashmi
package com.mphasis.car.dao;

import java.util.List;

import javax.transaction.Transactional;

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
		return dr;
	}

	public List<Driver> getDrivers() {
		Session session=sessionFactory.openSession();
		List<Driver> driver=session.createCriteria(Driver.class).list();
		return driver;
	}

	public void insertDriver(Driver driver) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(driver);
		tr.commit();
	}

	public void updateDriver(Driver driver) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(driver);
		tr.commit();
	}

	public void deleteDriver(String id) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.delete(id);
		tr.commit();
	}

	public Driver login(String did, String pass) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Query query=session.createQuery("from cabDriver where did:did  and dpass:dpass");
		query.setString("did", did);
		query.setString("dpass", pass);
		Driver driver=(Driver) query.uniqueResult();
		tr.commit();
		return null;
	}

	public void changepassword(String oldpass, String newpass) {
	Session session=sessionFactory.openSession();
	Transaction tr=session.beginTransaction();
	Driver driver=(Driver) session.get(Driver.class, newpass);
	driver.setDpass(newpass);
	session.update(newpass);
	tr.commit();
	

	}

	public void signup(Driver driver) {
		Session session=sessionFactory.openSession();
		Transaction  tr=session.beginTransaction();
		session.save(driver);
		tr.commit();
		session.close();
		
	}

}
