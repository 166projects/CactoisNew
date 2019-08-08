//Bhuma Pravallika
package com.mphasis.car.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.car.entities.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	SessionFactory sessionFactory;
	public void updateuser(User user) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(user);
		tr.commit();
	}

	public void deleteuser(int id) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		User user=(User) session.get(User.class, id);
		session.delete(id);
		tr.commit();
	}

	public User login(String email, String pass) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Query query=sessionFactory.openSession().createQuery("from User where cemail=:cemail and cpass=:cpass");
		query.setString("cemail",email);
		query.setString("cpass",pass);
		User user=(User) query.uniqueResult();
		tr.commit();
		return user;
	}

	public void changepassword(String oldpass, String newpass) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		User u=(User) session.get(User.class, newpass);
		u.setUpass(newpass);
		session.update(u);
		tr.commit();
		session.close();
	}

	public void signup(User u) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(u);
		tr.commit();
	}

	public User getUsersById(int id) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		User u=(User) session.get(User.class, id);
		tr.commit();
		return u;
	}

	public User getUsersByName(String name) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		User u=(User) session.get(User.class, name);
		tr.commit();
		return u;
	}

	public List<User> getUsers() {
		Session session=sessionFactory.openSession();
		List<User> user=session.createCriteria(User.class).list();
		return user;
	}

}
