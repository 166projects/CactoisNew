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
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="cabUser")
	public class User implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cid;
	@Column(nullable=false,length=25)
	private String uname;
	@Column(nullable=false)
	private String uemail;
	@Column(nullable=false)
	private String upass;
	@Column(nullable=false)
	private long uphnum;
	@Column(nullable=false)
	private String ugender;
	@Column(nullable=false)
	private String uidproof;
	@Column(nullable=false)
	private int ucusrating;
	@Column(nullable=false)
	private Long emgcontact;
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Route> route;
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Booking> booking;
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Payment> payment;
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JsonIgnore
	private List<HelpDesk> HelpDesk;
	public int getUid() {
		return cid;
	}
	public void setUid(int cid) {
		this.cid = cid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public long getUphnum() {
		return uphnum;
	}
	public void setUphnum(long uphnum) {
		this.uphnum = uphnum;
	}
	public String getUgender() {
		return ugender;
	}
	public void setUgender(String ugender) {
		this.ugender = ugender;
	}
	public String getUidproof() {
		return uidproof;
	}
	public void setUidproof(String uidproof) {
		this.uidproof = uidproof;
	}
	public int getUcusrating() {
		return ucusrating;
	}
	public void setUcusrating(int ucusrating) {
		this.ucusrating = ucusrating;
	}
	public Long getEmgcontact() {
		return emgcontact;
	}
	public void setEmgcontact(Long emgcontact) {
		this.emgcontact = emgcontact;
	}
	public List<Route> getRoute() {
		return route;
	}
	public void setRoute(List<Route> route) {
		this.route = route;
	}
	public List<Booking> getBooking() {
		return booking;
	}
	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}
	public List<Payment> getPayment() {
		return payment;
	}
	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}
	public List<HelpDesk> getHelpDesk() {
		return HelpDesk;
	}
	public void setHelpDesk(List<HelpDesk> helpDesk) {
		HelpDesk = helpDesk;
	}
	@Override
	public String toString() {
		return "User [cid=" + cid + ", uname=" + uname + ", uemail=" + uemail + ", upass=" + upass + ", uphnum="
				+ uphnum + ", ugender=" + ugender + ", uidproof=" + uidproof + ", ucusrating=" + ucusrating
				+ ", emgcontact=" + emgcontact + ", route=" + route + ", booking=" + booking + ", payment=" + payment
				+ ", HelpDesk=" + HelpDesk + "]";
	}

	}



