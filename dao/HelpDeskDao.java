/**
 * 
 */
package com.mphasis.car.dao;

import java.util.List;

import com.mphasis.car.entities.HelpDesk;

/**
 * @author su.keerthanaa
 *
 */
public interface HelpDeskDao {

	public void addComplaint(HelpDesk helpDesk);
	public void deleteComplaint(String hid);
	public List<HelpDesk> getAllComplaints();
	public List<HelpDesk> getUserComplaints();
	public List<HelpDesk> getDriverComplaints();
	
}
