package com.mphasis.car.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mphasis.car.util.StringPrefixedSequenceIdGenerator;

@Entity(name="cabHelpDesk")
public class HelpDesk {
@Id
//@GeneratedValue(strategy=GenerationType.AUTO)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_seq")
@GenericGenerator(
		            name = "car_seq",
		            strategy = "com.mphasis.car.util.StringPrefixedSequenceIdGenerator",
		            parameters = {
				                   @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "4"),
				                   @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "H"),
				                   @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d")})

private String hid;
@Column(nullable=false)
private int id;
@Column(nullable=false)
private String compliant;
@ManyToOne(fetch=FetchType.EAGER)
private User user;
/*@ManyToOne(fetch=FetchType.EAGER)
private Admin admin;*/
@ManyToOne(fetch=FetchType.EAGER)
private Driver driver;
public Driver getDriver() {
	return driver;
}
public void setDriver(Driver driver) {
	this.driver = driver;
}
public String getHid() {
return hid;
}
public void setHid(String hid) {
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
//@Override
//public String toString() {
//return "HelpDesk [hid=" + hid + ", id=" + id + ", compliant=" + compliant + ", user=" + user + "]";
//}
}

