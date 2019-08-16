/**
 * 
 */
package com.mphasis.car.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.car.dao.HelpDeskDao;
import com.mphasis.car.entities.HelpDesk;

/**
 * @author su.keerthanaa
 *
 */
@Service
public class HelpDeskBoImpl implements HelpDeskBo {
	
	@Autowired
	HelpDeskDao helpDeskDao;

	public void insertComplaint(HelpDesk helpDesk) {
		
		if(helpDesk.getCompliant().length()>0)
		helpDeskDao.addComplaint(helpDesk);
	}

	public void removeComplaint(String hid) {
		
		helpDeskDao.deleteComplaint(hid);
	}

	public List<HelpDesk> getAllComplaints() {
		
		return helpDeskDao.getAllComplaints();
	}

	public List<HelpDesk> getUserComplaints() {
		
		return helpDeskDao.getUserComplaints();
	}

	public List<HelpDesk> getDriverComplaints() {
		
		return helpDeskDao.getDriverComplaints();
	}

}
