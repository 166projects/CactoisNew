package com.mphasis.car.bo;

import com.mphasis.car.entities.Admin;
import com.mphasis.car.exception.BuisnessException;

public interface AdminBo {
	public void editAdminDetails(Admin admins);
	public void makeAdmin(String cid);
	public void deleteAdmin(String id) throws BuisnessException;
	public void changePassword(String oldpass,String newpass) throws BuisnessException;
	public void addNewAdmin(Admin admins) throws BuisnessException;
}
