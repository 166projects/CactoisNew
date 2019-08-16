//Bhuma Pravallika
package com.mphasis.car.dao;

import java.util.List;

import com.mphasis.car.entities.User;

public interface UserDao {
	public void updateuser(User user);
	public void deleteuser(String id);
	public User login(String uemail,String upass);
	public void changepassword(String cid,String oldpass,String newpass);
	public void signup(User u);
	public User getUsersById(String id);
	public List<User> getUsersByName(String name);
	public List<User> getUsers();
}
