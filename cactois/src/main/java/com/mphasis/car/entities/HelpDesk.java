package com.mphasis.car.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name="cabHelpDesk")
public class HelpDesk {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int hid;
@Column(nullable=false)
private int id;
@Column(nullable=false)
private String compliant;
@ManyToOne
private User user;
@ManyToOne
private Admin admin;
@ManyToOne
private Driver driver;
public Driver getDriver() {
	return driver;
}
public void setDriver(Driver driver) {
	this.driver = driver;
}
public int getHid() {
return hid;
}
public void setHid(int hid) {
this.hid = hid;
}
public int getId() {
return id;
}
public void setId(int id) {
this.id = id;
}
public String getCompliant() {
return compliant;
}
public void setCompliant(String compliant) {
this.compliant = compliant;
}
public User getUser() {
return user;
}
public void setUser(User user) {
this.user = user;
}
@Override
public String toString() {
return "HelpDesk [hid=" + hid + ", id=" + id + ", compliant=" + compliant + ", user=" + user + "]";
}
}

