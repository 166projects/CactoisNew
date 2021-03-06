//Bhuma Pravallika
package com.mphasis.car.bo;

import java.util.List;

import com.mphasis.car.entities.User;

public interface UserBo {
	public void updateuser(User user);
	public void deleteuser(String id);
	public User login(String email,String pass) throws Exception;
	public void changepassword(String cid,String oldpass,String newpass) throws Exception;
	public void signup(User u) throws Exception;
	public User getUsersById(String id) throws Exception;
	public List<User> getUsersByName(String name) throws Exception;
	public List<User> getUser();
}
