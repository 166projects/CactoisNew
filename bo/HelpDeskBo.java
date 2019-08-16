/**
 * 
 */
package com.mphasis.car.bo;

import java.util.List;

import com.mphasis.car.entities.HelpDesk;

/**
 * @author su.keerthanaa
 *
 */
public interface HelpDeskBo {

	public void insertComplaint(HelpDesk helpDesk);
	public void removeComplaint(String hid);
	public List<HelpDesk> getAllComplaints();
	public List<HelpDesk> getUserComplaints();
	public List<HelpDesk> getDriverComplaints();
}
