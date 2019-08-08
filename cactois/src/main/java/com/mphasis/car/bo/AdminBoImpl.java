package com.mphasis.car.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.car.dao.AdminDao;
import com.mphasis.car.entities.User;
import com.mphasis.car.exception.BuisnessException;

@Service
public class AdminBoImpl implements AdminBo {
@Autowired
AdminDao adminDao; 
	public void editadmindetails(User users) {
			
	}

	public void addadmin(int cid) {
			
		
	}

	public void deleteadmin(int cid) throws BuisnessException {
		if(cid>0)
			adminDao.deleteadmin(cid);
		else
			throw new BuisnessException("CID Doesn't exist");
	}

	public void changepassword(int cid) {
		// TODO Auto-generated method stub
		
	}

}
