package com.mphasis.car.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity(name="cabVechile")
public class Vehicle  implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int vno;
	private int vtype;
	private String vstatus;
	private int vseats;
	
	private Driver driver;
	@OneToMany(mappedBy="vehicle")
	private List<Booking> booking;
	public int getVno() {
		return vno;
	}
	public void setVno(int vno) {
		this.vno = vno;
	}
	public int getVtype() {
		return vtype;
	}
	public void setVtype(int vtype) {
		this.vtype = vtype;
	}
	public String getVstatus() {
		return vstatus;
	}
	public void setVstatus(String vstatus) {
		this.vstatus = vstatus;
	}
	public int getVseats() {
		return vseats;
	}
	public void setVseats(int vseats) {
		this.vseats = vseats;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	 
	public List<Booking> getBooking() {
		return booking;
	}
	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}
	@Override
	public String toString() {
		return "Vechile [vno=" + vno + ", vtype=" + vtype + ", vstatus=" + vstatus + ", vseats=" + vseats + ", driver="
				+ driver + "]";
	}
	
	
	

}
