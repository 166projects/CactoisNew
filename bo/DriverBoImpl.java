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
		
		return driver;
	}

	

	public void updateDriver(Driver driver) {
		driverDao.updateDriver(driver);
		
	}

	public void deleteDriver(String id) {
		driverDao.deleteDriver(id);
		
	}

	public Driver login(String demail, String pass)  throws Exception{
//	       if((pass.matches("[a-zA-Z]")))
//	              return driverDao.login(demail, pass);
//	       else 
//	              throw new Exception("Wrong Id or password");
		return driverDao.login(demail, pass);
	       }

	       public void changepassword(String did,String oldpass, String newpass)throws Exception {
	              System.out.println(oldpass);
	              System.out.println(newpass);
	              if(oldpass.matches(newpass))
	                     throw new Exception("old password is same");
	              else
	                     driverDao.changepassword(did, oldpass, newpass);
	       }

		 
		public void signup(Driver driver) {
			// TODO Auto-generated method stub
			driverDao.signup(driver);
		}

	/*public void signup(Driver driver)
	{
		
		
	}*/

}
