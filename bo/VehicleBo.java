/**
 * 
 */
package com.mphasis.car.bo;

import java.util.List;

import com.mphasis.car.entities.Vehicle;

/**
 * @author su.keerthanaa
 *
 */
public interface VehicleBo {
	public void insertVehicle(Vehicle vehicle);
	public void updateVehicle(Vehicle vehicle);
	public Vehicle getVechicleByNo(String vno);
	public List<Vehicle> getVehicleByLocation(String location);
	public List<Vehicle> getVehicleByType(String type);
	public void deleteVehicle(String vno);
	public List<Vehicle> getAllVehicles();

}
