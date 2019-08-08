//Bhuma Pravallika
package com.mphasis.car.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.car.dao.UserDao;
import com.mphasis.car.entities.User;
@Service
public class UserBoImpl implements UserBo {
	@Autowired
	UserDao userDao;
	public void updateuser(User user) {
		userDao.updateuser(user);
	}

	public void deleteuser(int id) {
		userDao.deleteuser(id);
	}

	public User login(String email, String pass) throws Exception{
		User user=null;
		if(email.matches("([a-zA-Z0-9]{8,})@gmail.com") && pass.matches("[a-zA-Z]{8,}"))
			user=userDao.login(email, pass);
		else
			throw new Exception("invalid pattern");
		return user;
	}

	public void changepassword(String oldpass, String newpass) throws Exception {
		if(oldpass.matches(newpass))
			throw new Exception("Old and New Password is same");
		else
			throw new Exception("Password is changed");
	}

	public void signup(User u) throws Exception {
		if((u.getUname().matches("[A-Za-z]{3,10}")) && (u.getUgender().matches("[MmfF]{1}")) && 
				(u.getEmgcontact()>1L) && (u.getUemail().matches("[a-zA-Z0-9]{4,15}@gmail.com")))
			userDao.signup(u);
		else
			throw new Exception("Cannot Signup");
	}

	public User getUsersById(int id) throws Exception{
		User user=null;
		if(id>1 && id<1000)
			user=userDao.getUsersById(id);
		else
			throw new Exception("No User with this id");
		return user;
	}

	public List<User> getUsersByName(String name) throws Exception {
		List<User> user=new ArrayList<User>();
		if(name.matches("[a-zA-Z]{3,10}"))
			user=(List<User>) userDao.getUsersByName(name);
		else
			throw new Exception("Invalid Name");
		return user;
	}

	public List<User> getUser() {
		// TODO Auto-generated method stub
		return null;
	}

}
