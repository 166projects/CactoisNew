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
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mphasis.car.util.StringPrefixedSequenceIdGenerator;

@Entity(name="CabAdmin")
public class Admin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_seq")
	@GenericGenerator(
			            name = "car_seq",
			            strategy = "com.mphasis.car.util.StringPrefixedSequenceIdGenerator",
			            parameters = {
					                   @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "4"),
					                   @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "A"),
					                   @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d")})

	private String aid;
	@Column(nullable=false,length=25)
	private String aname;
	@Column(nullable=false)
	private String aemail;
	@Column(nullable=false)
	private String apass;
	@Column(nullable=false)
	private long aphnum;
	@Column(nullable=false)
	private String agender;
	@Column(nullable=false)
	private String aidproof;
	@Column(nullable=false)
	private Long emgcontact;
	 
	/*@OneToMany(mappedBy="admin",fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Booking> booking;
	
	@OneToMany(mappedBy="admin",fetch=FetchType.LAZY)
	@JsonIgnore
	private List<HelpDesk> HelpDesk;*/
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getAemail() {
		return aemail;
	}
	public void setAemail(String aemail) {
		this.aemail = aemail;
	}
	public String getApass() {
		return apass;
	}
	public void setApass(String apass) {
		this.apass = apass;
	}
	public long getAphnum() {
		return aphnum;
	}
	public void setAphnum(long aphnum) {
		this.aphnum = aphnum;
	}
	public String getAgender() {
		return agender;
	}
	public void setAgender(String agender) {
		this.agender = agender;
	}
	public String getAidproof() {
		return aidproof;
	}
	public void setAidproof(String aidproof) {
		this.aidproof = aidproof;
	}
	public Long getEmgcontact() {
		return emgcontact;
	}
	public void setEmgcontact(Long emgcontact) {
		this.emgcontact = emgcontact;
	}
	 
//	public List<Booking> getBooking() {
//		return booking;
//	}
//	public void setBooking(List<Booking> booking) {
//		this.booking = booking;
//	}
//	
//	public List<HelpDesk> getHelpDesk() {
//		return HelpDesk;
//	}
//	public void setHelpDesk(List<HelpDesk> helpDesk) {
//		HelpDesk = helpDesk;
//	}
	
	
}
