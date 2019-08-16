package com.mphasis.car.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.car.entities.Admin;
import com.mphasis.car.entities.Location;

@Repository
public class LocationDaoImpl implements LocationDao
{

@Autowired
SessionFactory sessionFactory;
public void setSessionFactory(SessionFactory sessionFactory) {
 this.sessionFactory = sessionFactory;
}
public void addNewLocation(Location location) {
 Session session=sessionFactory.openSession();
 Transaction tr=session.beginTransaction();
 session.save(location);
 tr.commit();
 session.close();
}
public void editFair(String id,int km)
{
 Session session=sessionFactory.openSession();
 Transaction tr=session.beginTransaction();
 Location loc=(Location) session.get(Location.class,id);
 loc.setKm(km);
 session.update(loc);
 tr.commit();
 session.close();
}

public void deleteLoc(String id)
{
 Session session=sessionFactory.openSession();
 Transaction tr=session.beginTransaction();
 Location loc=(Location) session.get(Location.class,id);
 session.delete(loc);
 tr.commit();
 session.close();
}
public List<Location> getLocations()
{
 List<Location> locations = null;
 Session session=sessionFactory.openSession();
 Transaction tr=session.beginTransaction();
 locations =session.createCriteria(Location.class).list();
  
 tr.commit();
 session.close();
 return locations;
}
public int calcfare(String type,String source, String dest) {
	 int fare =0;
	 Session session=sessionFactory.openSession();
	 Transaction tr=session.beginTransaction();
	 TypedQuery q = session.createQuery(" from cabLocations where source=:source and destination=:dest");
	 q.setParameter("source", source);
	 q.setParameter("dest", dest);
	 Location l=(Location) q.getSingleResult();
	 
	 fare = l.getKm();
	 if(type.equalsIgnoreCase("mini"))
	 {
		 System.out.println("fare =7"+l);
		 fare = fare * 7;
	 }
	 else if(type.equalsIgnoreCase("saden"))
	 {
		 fare = fare * 9;
	 }
	 else if(type.equalsIgnoreCase("prime"))
	 {
		 fare = fare * 11;
	 }
	 else if(type.equalsIgnoreCase("micro"))
	 {
		 fare = fare * 5;
	 }
	 
	 return fare;
}
 
}
