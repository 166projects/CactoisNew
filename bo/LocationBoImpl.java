package com.mphasis.car.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.car.dao.LocationDao;
import com.mphasis.car.entities.Location;
@Service
public class LocationBoImpl implements LocationBo {

@Autowired
LocationDao locationDao;
public void addNewLocation(Location location) {
 locationDao.addNewLocation(location);

}

public void editFair(String id, int km) {
  
 locationDao.editFair(id, km);
}

public void deleteLoc(String id) {
  
 locationDao.deleteLoc(id);
}

public List<Location> getLocations() {
 
 return locationDao.getLocations();
}

public int calcfare(String type, String source, String dest) {
	 
	return locationDao.calcfare(type, source, dest);
}

}
