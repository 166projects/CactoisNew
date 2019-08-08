package com.mphasis.car.bo;

import com.mphasis.car.entities.User;
import com.mphasis.car.exception.BuisnessException;

public interface AdminBo {
	public void editadmindetails(User users);
	public void addadmin(int cid);
	public void deleteadmin(int cid) throws BuisnessException;
	public void changepassword(int cid);
}
