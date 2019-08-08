package com.mphasis.car.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity(name="cabDriver")
public class Driver implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
 private int did;
	@Column(nullable=false)
 private String dname;
	@Column(nullable=false)
 private int dphno;
	@Column(nullable=false)
 private String dadno;
	@Column(nullable=false)
 private int drating;
	@Column(nullable=false)
 private int drides;
	@Column(nullable=false)
 private int dsalary;
	@Column(nullable=false)
 private Vehicle vehicle;
 @ManyToOne
 private User user;
 @OneToMany(mappedBy="driver")
 private List<Route> route;
 @OneToMany(mappedBy="user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JsonIgnore
	private List<HelpDesk> HelpDesk;
public int getDid() {
	return did;
}
public void setDid(int did) {
	this.did = did;
}
public String getDname() {
	return dname;
}
public void setDname(String dname) {
	this.dname = dname;
}
public int getDphno() {
	return dphno;
}
public void setDphno(int dphno) {
	this.dphno = dphno;
}
public String getDadno() {
	return dadno;
}
public void setDadno(String dadno) {
	this.dadno = dadno;
}
public int getDrating() {
	return drating;
}
public void setDrating(int drating) {
	this.drating = drating;
}
public int getDrides() {
	return drides;
}
public void setDrides(int drides) {
	this.drides = drides;
}
public int getDsalary() {
	return dsalary;
}
public void setDsalary(int dsalary) {
	this.dsalary = dsalary;
}

public Vehicle getVehicle() {
	return vehicle;
}
public void setVehicle(Vehicle vehicle) {
	this.vehicle = vehicle;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
 
public List<Route> getRoute() {
	return route;
}
public void setRoute(List<Route> route) {
	this.route = route;
}
@Override
public String toString() {
	return "Driver [did=" + did + ", dname=" + dname + ", dphno=" + dphno + ", dadno=" + dadno + ", drating=" + drating
			+ ", drides=" + drides + ", dsalary=" + dsalary + ", vehicle=" + vehicle + ", user=" + user + ", route="
			+ route + "]";
}
 
}
