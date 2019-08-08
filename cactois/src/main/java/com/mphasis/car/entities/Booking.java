package com.mphasis.car.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity(name="cabBooking")
public class Booking implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bid;
	@Column(nullable=false)
	private String source;
	@Column(nullable=false)
	private String destination;
	public int getFair() {
		return fair;
	}

	public void setFair(int fair) {
		this.fair = fair;
	}

	@Column(nullable=false)
	private int fair;
	//@Temporal(TemporalType.TIMESTAMP)
	//private Date dob;
	@Column(insertable=false,columnDefinition="date default sysdate")
	private String reg_date;
	@Column(nullable=false)
	private String status;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Admin admin;
	
	@OneToOne
	private Payment payment;
	
	@ManyToOne
	private Vehicle vehicle;

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
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

	/*public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}*/

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "Booking [bid=" + bid + ", source=" + source + ", destination=" + destination + ", fair=" + fair
				+ ", reg_date=" + reg_date + ", status=" + status + ", user=" + user + ", payment=" + payment
				+ ", vehicle=" + vehicle + "]";
	}
	
	
	
	
	
}
