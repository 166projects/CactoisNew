package com.mphasis.car.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mphasis.car.util.StringPrefixedSequenceIdGenerator;

@Entity(name="cabUser")
	public class User implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_seq")
	@GenericGenerator(
			            name = "payment_seq",
			            strategy = "com.mphasis.car.util.StringPrefixedSequenceIdGenerator",
			            parameters = {
					                   @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "4"),
					                   @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "U"),
					                   @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d")})

	private String cid;
	@Column(nullable=false,length=25)
	private String uname;
	@Column(nullable=false,unique=true)
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
	private String permanent_Address;
	@Column(nullable=false)
	private String current_Address;
	@Column(nullable=false)
	private long emgcontact;
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Booking> booking;
	
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY)
	@JsonIgnore
	private List<HelpDesk> helpDesk;
	
	/*@OneToMany(mappedBy="user",fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Vehicle> vehicle;*/
	
	 
	public String getUemail() {
		return uemail;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
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
	public long getEmgcontact() {
		return emgcontact;
	}
	public void setEmgcontact(long emgcontact) {
		this.emgcontact = emgcontact;
	}
	 
	public List<Booking> getBooking() {
		return booking;
	}
	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}
	
	public List<HelpDesk> getHelpDesk() {
		return helpDesk;
	}
	public void setHelpDesk(List<HelpDesk> helpDesk) {
		this.helpDesk = helpDesk;
	}
//	@Override
//	public String toString() {
//		return "User [cid=" + cid + ", uname=" + uname + ", uemail=" + uemail + ", upass=" + upass + ", uphnum="
//				+ uphnum + ", ugender=" + ugender + ", uidproof=" + uidproof + ", ucusrating=" + ucusrating
//				+ ", emgcontact=" + emgcontact + ", booking=" + booking + ", HelpDesk=" + HelpDesk + ", vehicle="
//				+ vehicle + "]";
//	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	/*public List<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}*/
	public String getPermanent_Address() {
		return permanent_Address;
	}
	public void setPermanent_Address(String permanent_Address) {
		this.permanent_Address = permanent_Address;
	}
	public String getCurrent_Address() {
		return current_Address;
	}
	public void setCurrent_Address(String current_Address) {
		this.current_Address = current_Address;
	}

	}



