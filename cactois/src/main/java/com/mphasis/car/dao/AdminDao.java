package com.mphasis.car.dao;

import com.mphasis.car.entities.User;

public interface AdminDao {
	public void editadmindetails(User users);
	public void addadmin(int cid);
	public void deleteadmin(int cid);
	public void changepassword(int cid);
}
