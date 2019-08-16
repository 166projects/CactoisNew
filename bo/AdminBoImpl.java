package com.mphasis.car.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.car.dao.AdminDao;
import com.mphasis.car.entities.Admin;
import com.mphasis.car.exception.BuisnessException;

@Service
public class AdminBoImpl implements AdminBo {
@Autowired
AdminDao adminDao; 
	public void editAdminDetails(Admin admins) {
		
		adminDao.editAdminDetails(admins);
	}
	public void deleteAdmin(String aid) throws BuisnessException {
		if(aid!=null)
			adminDao.deleteAdmin(aid);
		else
			throw new BuisnessException("AID Doesn't exist");
	}

	public void changePassword(String oldpass,String newpass) throws BuisnessException {
		if(oldpass.matches(newpass))
			try {
				throw new Exception("Old and New Password is same");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
			 adminDao.changePassword(oldpass,newpass);
		
	}

	public void makeAdmin(String cid) {
		adminDao.makeAdmin(cid);
		
	}
	public void addNewAdmin(Admin admins) throws BuisnessException {
		if((admins.getAname().matches("[A-Za-z]{3,10}")) && (admins.getAgender().matches("[MmfF]{1}")) && 
				(admins.getEmgcontact()>1L) && (admins.getAemail().matches("[a-zA-Z0-9]{4,15}@gmail.com")))
		{
			adminDao.addNewAdmin(admins);
		} else
			try {
				throw new Exception("Cannot Add New Admin");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}


}
