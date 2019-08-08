package com.mphasis.car.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity(name="cabRoute")
public class Route implements Serializable{
		
		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int rid;
		@Column(nullable=false)
		private String source;
		@Column(nullable=false)
		private String destination;
		@Column(nullable=false)
		private int duration;
		@Column(nullable=false)
		private int distance;
		@Column(nullable=false)
		private int fare;
		@ManyToOne(fetch=FetchType.EAGER,optional=false)
		private User user;
		@ManyToOne(fetch=FetchType.EAGER,optional=false)
		private Driver driver;
		public int getRid() {
		 return rid;
		}
		public void setRid(int rid) {
		 this.rid = rid;
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
		public int getDuration() {
		 return duration;
		}
		public void setDuration(int duration) {
		 this.duration = duration;
		}
		public int getDistance() {
		 return distance;
		}
		public void setDistance(int distance) {
		 this.distance = distance;
		}
		public int getFare() {
		 return fare;
		}
		public void setFair(int fare) {
		 this.fare = fare;
		}
		public User getUser() {
		 return user;
		}
		public void setUser(User user) {
		 this.user = user;
		}

		}



