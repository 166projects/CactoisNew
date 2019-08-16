//Bhuma Pravallika
package com.mphasis.car.dao;

import java.util.List;

 

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
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
		session.close();
	}

	public void deleteuser(String id) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		User user=(User) session.get(User.class, id);
		session.delete(id);
		tr.commit();
		session.close();
	}

	public User login(String email, String pass) {
        Session session=sessionFactory.openSession();
        Transaction tr=session.beginTransaction();
       ///User user=(User) session.get(User.class, email);
        Query query=session.createQuery("from cabUser where uemail=:uemail and upass=:upass");
        query.setString("uemail",email);
        query.setString("upass",pass);
        System.out.println(email);
        User user=(User) query.uniqueResult();
        tr.commit();
        
        System.out.println(user);
        session.close();
        return user;
        //User user = (User)session.createCriteria(User.class).add(Restrictions.eq("uemail",email));
 }

 public void changepassword(String cid,String oldpass, String newpass) {
        Session session=sessionFactory.openSession();
        Transaction tr=session.beginTransaction();
        User user=(User) session.get(User.class,cid);
        user.setUpass(newpass);
        System.out.println(newpass);
        System.out.println(user);
        session.update(user);
        tr.commit();
        session.close();
 }


	public void signup(User u) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(u);
		tr.commit();
		session.close();
	}

	public User getUsersById(String id) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		User u=(User) session.get(User.class, id);
		//User u=(User) session.createCriteria(User.class).add(Restrictions.eq("cid", id));
		tr.commit();
		session.close();
		return u;
	}

	public List<User> getUsersByName(String name) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		//User u=(User) session.get(User.class, name);
		List<User> user=session.createCriteria(User.class).add(Restrictions.eq("uname", name)).list();
		tr.commit();
		session.close();
		return user;
	}

	public List<User> getUsers() {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		List<User> user=session.createCriteria(User.class).list();
		tr.commit();
		session.close();
		return user;
	}

}
