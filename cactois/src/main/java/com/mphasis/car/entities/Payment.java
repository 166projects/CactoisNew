package com.mphasis.car.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name="cabPayment")
	public class Payment  implements Serializable{

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int pid;
		@Column(nullable=false)
		private String type;
		@Column(nullable=false)
		private String status;
		
		@OneToOne
		private Booking booking;
		
		@ManyToOne
		private User user;

		public int getPid() {
			return pid;
		}

		public void setPid(int pid) {
			this.pid = pid;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Booking getBooking() {
			return booking;
		}

		public void setBooking(Booking booking) {
			this.booking = booking;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		@Override
		public String toString() {
			return "Payment [pid=" + pid + ", type=" + type + ", status=" + status + ", booking=" + booking + "]";
		}

		
		
	}


