//Bhuma Pravallika
package com.mphasis.car.dao;

import java.util.List;

import com.mphasis.car.entities.User;

public interface UserDao {
	public void updateuser(User user);
	public void deleteuser(int id);
	public User login(String email,String pass);
	public void changepassword(String oldpass,String newpass);
	public void signup(User u);
	public User getUsersById(int id);
	public User getUsersByName(String name);
	public List<User> getUsers();
}
