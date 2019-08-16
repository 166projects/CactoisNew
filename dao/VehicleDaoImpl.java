/**
 * 
 */
package com.mphasis.car.dao;

/**
 * @author su.keerthanaa
 *
 */

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mphasis.car.entities.Vehicle;
@Repository
public class VehicleDaoImpl implements VehicleDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public void insertVehicle(Vehicle vehicle) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		try {
		session.save(vehicle);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		tr.commit();
		session.close();
	}

	public void updateVehicle(Vehicle vehicle) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		try {
		session.update(vehicle);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		tr.commit();
		session.close();
	}

	public Vehicle getVechicleByNo(String vno) {
		
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Vehicle v=(Vehicle)session.get(Vehicle.class, vno);
		tr.commit();
			
		session.close();
		return v;
		}

	public List<Vehicle> getVehicleByLocation(String location) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		List<Vehicle> vehicles=session.createCriteria(Vehicle.class).
				add(Restrictions.eq("vlocation", location)).list();
		tr.commit();
		session.close();
		
		return vehicles;
	}
	public List<Vehicle> getVehicleByType(String type) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		List<Vehicle> vehicles=session.createCriteria(Vehicle.class).
				add(Restrictions.eq("vtype", type)).list();
		tr.commit();
		session.close();
		
		return vehicles;
	}


	public void deleteVehicle(String vno) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		try {
		Vehicle v=(Vehicle)session.get(Vehicle.class, vno);
		v.setDriver(null);
		session.delete(v);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		tr.commit();
		session.close();
		
	}

	public List<Vehicle> getAllVehicles() {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		List<Vehicle> vehicles=session.createCriteria(Vehicle.class).list();
		
		tr.commit();
		session.close();

		return vehicles;	
		}
}
