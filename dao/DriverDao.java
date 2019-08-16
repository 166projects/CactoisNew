//Peri Rashmi
package com.mphasis.car.dao;

import java.util.List;

import com.mphasis.car.entities.Driver;
import com.mphasis.car.entities.User;

public interface DriverDao {
	public  Driver getDriverById(String id);
	public List<Driver> getDrivers();
	//public void insertDriver(Driver driver);
	public void updateDriver(Driver driver);
	public void deleteDriver(String id);
	public Driver login(String demail,String pass) throws Exception;
	public void changepassword(String did,String oldpass,String newpass) throws Exception;
	public void signup(Driver driver);
	//public void insertDriver(Driver driver);
}
