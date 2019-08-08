package com.mphasis.car.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.car.entities.User;
@Repository
public class AdminDaoImpl implements AdminDao{
	@Autowired
	SessionFactory sessionFactory;
	public void editadmindetails(User users) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(users);
		tr.commit();
	}
	public void addadmin(int cid) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		User us=(User) session.get(User.class,cid);
		session.update(us);
		tr.commit();
	}
	public void deleteadmin(int cid) {

			Session session=sessionFactory.openSession();
			Transaction tr=session.beginTransaction();
			User us=(User) session.get(User.class,cid);
			session.delete(us);
			tr.commit();
	}
	public void changepassword(int cid) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		User us=(User) session.get(User.class,cid);
		session.update(us);
		tr.commit();
	}

}
