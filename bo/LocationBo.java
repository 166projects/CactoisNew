package com.mphasis.car.bo;

import java.util.List;

import com.mphasis.car.entities.Location;

public interface LocationBo {
public void addNewLocation(Location location);
public void editFair(String id,int km);
public void deleteLoc(String id);
public List<Location> getLocations();
public int calcfare(String type,String source, String dest) ;
}