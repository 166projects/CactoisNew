package com.mphasis.car.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mphasis.car.entities.Admin;
import com.mphasis.car.entities.User;
@Repository
public class AdminDaoImpl implements AdminDao{
	
	@Autowired
	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void editAdminDetails(Admin admins) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(admins);
		tr.commit();
		session.close();
	}
	
	public void deleteAdmin(String aid) {

			Session session=sessionFactory.openSession();
			Transaction tr=session.beginTransaction();
			Admin ad=(Admin) session.get(Admin.class,aid);
			session.delete(ad);
			tr.commit();
			session.close();
	}
	public void changePassword(String oldpass,String newpass) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Admin ad=(Admin) session.get(Admin.class,newpass);
		session.update(ad);
		tr.commit();
		session.close();
	}
	public void makeAdmin(String cid) {
		
			Session session=sessionFactory.openSession();
			Transaction tr=session.beginTransaction();
			User user=(User) session.get(User.class,cid);
			Admin admin= new Admin();
			admin.setAemail(user.getUemail());
			admin.setAgender(user.getUgender());
			admin.setAidproof(user.getUidproof());
			admin.setAname(user.getUname());
			admin.setApass(user.getUpass());
			admin.setEmgcontact(user.getEmgcontact());
			/*admin.setHelpDesk(user.getHelpDesk());
			admin.setBooking(user.getBooking());*/
			session.save(admin);
			tr.commit();
			session.close();
	}
	public void addNewAdmin(Admin admins) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(admins);
		tr.commit();
		session.close();
	}

	


}
