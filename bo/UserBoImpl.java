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

	public void deleteuser(String id) {
		userDao.deleteuser(id);
	}

	public User login(String email, String pass) throws Exception{
        System.out.println(email);
        System.out.println(pass);
//        if(email.matches("([a-zA-Z0-9])@gmail.com") && pass.matches("[a-zA-Z]"))
//        {      
//             
//        }
//        else
//              throw new Exception("invalid pattern");
//        }
        return userDao.login(email, pass);
	}
   public void changepassword(String cid,String oldpass, String newpass) throws Exception {
        if(oldpass.matches(newpass))
               throw new Exception("Old and New Password is same");
        else {
               userDao.changepassword(cid,oldpass, newpass);
               throw new Exception("Password is changed");
        }
 }


	public void signup(User u) throws Exception {
		if((u.getUname().matches("[A-Za-z]{3,10}")) && (u.getUgender().matches("[MmfF]{1}")) && 
				(u.getEmgcontact()>1L) && (u.getUemail().matches("[a-zA-Z0-9]{4,15}@gmail.com")))
			userDao.signup(u);
		else
			throw new Exception("Cannot Signup");
	}

	public User getUsersById(String id) throws Exception{
		User user=null;
//		if(id>1 && id<1000)
//			
//		else
//			throw new Exception("No User with this id");
//		return user;
		user=userDao.getUsersById(id);
		return user;
	}

	public List<User> getUsersByName(String name) throws Exception {
		List<User> user=new ArrayList<User>();
		if(name.matches("[a-zA-Z]{3,10}"))
			user=userDao.getUsersByName(name);
		else
			throw new Exception("Invalid Name");
		return user;
	}

	public List<User> getUser() {
			
		return userDao.getUsers();
	}
	

}
