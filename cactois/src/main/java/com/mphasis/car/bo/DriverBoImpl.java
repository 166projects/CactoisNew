package com.mphasis.car.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.car.dao.DriverDao;
import com.mphasis.car.entities.Driver;
@Service
public class DriverBoImpl implements DriverBo {
@Autowired
DriverDao driverDao;
	public Driver getDriverById(String id) throws Exception{
		Driver driver=null;
		if(id.startsWith("D"))
			driver=driverDao.getDriverById(id);
		else
			throw new Exception("Driver is not available");
			
		return driver;
	}

	public List<Driver> getDrivers() throws Exception {
		List<Driver> driver=driverDao.getDrivers();
		if(driver.isEmpty())
			throw new Exception("Driver table is empty");
		
		return null;
	}

	

	public void updateDriver(Driver driver) {
		driverDao.updateDriver(driver);
		
	}

	public void deleteDriver(String id) {
		driverDao.deleteDriver(id);
		
	}

	public Driver login(String did, String pass)  throws Exception{
	Driver driver=null;
	if(did.startsWith("D")&&(pass.matches("[a-zA-Z]{8,}")))
		driverDao.login(did, pass);
	else 
		throw new Exception("Wrong Id or password");
		
		return null;
	}

	public void changepassword(String oldpass, String newpass)throws Exception {
		if(oldpass.matches(newpass))
			throw new Exception("old password is same");
		else
			throw new Exception("Password does not match");
		
	}

	public void signup(Driver driver) {
		// TODO Auto-generated method stub
		
	}

}
