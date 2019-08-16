package com.mphasis.car.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mphasis.car.util.StringPrefixedSequenceIdGenerator;



@Entity(name="cabBooking")
public class Booking implements Serializable{

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_seq")
	@GenericGenerator(
			            name = "car_seq",
			            strategy = "com.mphasis.car.util.StringPrefixedSequenceIdGenerator",
			            parameters = {
					                   @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "4"),
					                   @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "B"),
					                   @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d")})

	private String bid;
	@Column(nullable=false)
	private String source;
	@Column(nullable=false)
	private String destination;
	//@Temporal(TemporalType.TIMESTAMP)
	//private Date dob;
	@Column(insertable=false,columnDefinition="date default sysdate")
	private String reg_date;
	@Column(nullable=false)
	private String status;
	
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	private User user;
	
//	@ManyToOne(fetch=FetchType.EAGER)
//	private Admin admin;
	
	@OneToOne
	@JoinColumn(name="payment_id",nullable=false)
	private Payment payment;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Vehicle vehicle;
	
	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
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

//	@Override
//	public String toString() {
//		return "Booking [bid=" + bid + ", source=" + source + ", destination=" + destination + ", fair=" + fair
//				+ ", reg_date=" + reg_date + ", status=" + status + ", user=" + user + ", payment=" + payment
//				+ ", vehicle=" + vehicle + "]";
//	}
	
	
	
	
	
}
