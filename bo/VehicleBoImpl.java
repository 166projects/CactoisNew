/**
 * 
 */
package com.mphasis.car.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.car.dao.VehicleDao;
import com.mphasis.car.entities.Vehicle;

/**
 * @author su.keerthanaa
 *
 */
@Service
public class VehicleBoImpl implements VehicleBo {
	
	@Autowired
	VehicleDao vehicleDao;

	public void insertVehicle(Vehicle vehicle) {
		   vehicleDao.insertVehicle(vehicle);
	}

	public void updateVehicle(Vehicle vehicle) {
		vehicleDao.updateVehicle(vehicle);
		
	}

	public Vehicle getVechicleByNo(String vno) {
		return vehicleDao.getVechicleByNo(vno);
	}

	public List<Vehicle> getVehicleByLocation(String location) {
		return vehicleDao.getVehicleByLocation(location);
	}

	public List<Vehicle> getVehicleByType(String type) {
		return vehicleDao.getVehicleByType(type);
	}
	public void deleteVehicle(String vno) {
		vehicleDao.deleteVehicle(vno);		
	}

	public List<Vehicle> getAllVehicles() {
		
		return vehicleDao.getAllVehicles();

	}

}
