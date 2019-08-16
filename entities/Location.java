package com.mphasis.car.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="cabLocations")
public class Location {
@Id
private String lid;
@Column(nullable=false)
private String source;
@Column(nullable=false)
private String destination;
@Column(nullable=false)
private int km;
public String getLid() {
 return lid;
}
public void setLid(String lid) {
 this.lid = lid;
}
public String getSource() {
 return source;
}
public void setSource(String source) {
 this.source = source;
}
public String getDestination() {
 return destination;
}
public void setDestination(String destination) {
 this.destination = destination;
}
public int getKm() {
 return km;
}
public void setKm(int km) {
 this.km = km;
}
}