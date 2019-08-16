/**
 * 
 */
package com.mphasis.car.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mphasis.car.entities.HelpDesk;

/**
 * @author su.keerthanaa
 *
 */
@Transactional
@Repository
public class HelpDeskDaoImpl implements HelpDeskDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void addComplaint(HelpDesk helpDesk) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		try {
		
		session.save(helpDesk);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		tr.commit();
		session.close();
	}

	public void deleteComplaint(String hid) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		try {
			
			session.delete(hid);
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}	
		
		tr.commit();
		session.close();
	}
	

	public List<HelpDesk> getAllComplaints() {
		
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		List<HelpDesk>complaints=session.createCriteria(HelpDesk.class).list();
		tr.commit();
		session.close();
		return complaints;
	}

	public List<HelpDesk> getUserComplaints() {
		
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		List<HelpDesk> complaints;
	    complaints=session.createQuery("from HelpDesk where USER_CID like %U% ").list();
	    tr.commit();
	    session.close();
		return complaints;
	}

	public List<HelpDesk> getDriverComplaints()
	{
        Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		List<HelpDesk> complaints;
	    complaints=session.createQuery("from HelpDesk where DRIVER_DID like D% ").list();
	    tr.commit();
	    session.close();
		return complaints;
	}

	
	}

	
