package com.mphasis.car.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mphasis.car.util.StringPrefixedSequenceIdGenerator;
@Entity(name="cabVechile")
public class Vehicle  implements Serializable{
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	/*@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_seq")
	@GenericGenerator(
			            name = "payment_seq",
			            strategy = "com.mphasis.car.util.StringPrefixedSequenceIdGenerator",
			            parameters = {
					                   @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "4"),
					                   @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "V"),
					                   @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d")})
*/
	private String vno;
	@Column(nullable=false)
	private String vlocation;
	@Column(nullable=false)
	private String vtype;
	@Column(nullable=false)
	private String vstatus;
	@Column(nullable=false)
	private int vseats;
	@OneToOne()
	@JoinColumn(name="driver_id", nullable=true,unique = true)
	
	private Driver driver;
	@OneToMany(mappedBy="vehicle",fetch=FetchType.LAZY)
 
	@JsonIgnore
	private List<Booking> booking;
	//@Column(nullable=true)
	//@ManyToOne(fetch=FetchType.EAGER)
	//private User user;
	private double fare;
	/*public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}*/
	
	public double getFare() {
		return fare;
	}
	public String getVlocation() {
		return vlocation;
	}
	public void setVlocation(String vlocation) {
		this.vlocation = vlocation;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public String getVno() {
		return vno;
	}
	public void setVno(String vno) {
		this.vno = vno;
	}
	public String getVtype() {
		return vtype;
	}
	public void setVtype(String vtype) {
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
//	@Override
//	public String toString() {
//		return "Vehicle [vno=" + vno + ", vtype=" + vtype + ", vstatus=" + vstatus + ", vseats=" + vseats + ", booking="
//				+ booking + "]";
//	}

	
	
	

}
