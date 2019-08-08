package com.mphasis.car.bo;

import java.util.List;

import com.mphasis.car.entities.Driver;

public interface DriverBo {
	public  Driver getDriverById(String id)throws Exception;
	public List<Driver> getDrivers() throws Exception;
	
	public void updateDriver(Driver driver);
	public void deleteDriver(String id);
	public Driver login(String did,String pass) throws Exception;
	public void changepassword(String oldpass,String newpass) throws Exception;
	public void signup(Driver driver);
}
