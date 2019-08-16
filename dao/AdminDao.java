package com.mphasis.car.dao;

import com.mphasis.car.entities.Admin;

public interface AdminDao
 {
	public void editAdminDetails(Admin admins);
	public void addNewAdmin(Admin admins);
	public void deleteAdmin(String aid);
	public void changePassword(String oldpass, String newpass);
	public void makeAdmin(String cid);
}
