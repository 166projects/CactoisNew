package com.mphasis.car.bo;

import com.mphasis.car.entities.User;

public interface AdminBo {
	public void editadmindetails(User users);
	public void addadmin(int cid);
	public void deleteadmin(int cid);
	public void changepassword(int cid);
}
