package com.mphasis.car.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 

import com.mphasis.car.util.StringPrefixedSequenceIdGenerator;
 
@Entity(name="cabPayment")
	public class Payment  implements Serializable{

		@Id
		//@GeneratedValue(strategy=GenerationType.AUTO)
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_seq")
		@GenericGenerator(
				            name = "car_seq",
				            strategy = "com.mphasis.car.util.StringPrefixedSequenceIdGenerator",
				            parameters = {
						                   @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "4"),
						                   @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "P"),
						                   @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d")})

		private String pid;
		@Column(nullable=false)
		private String type;
		@Column(nullable=false)
		private String status;
		

		public String getPid() {
			return pid;
		}

		public void setPid(String pid) {
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

		

		

//		@Override
//		public String toString() {
//			return "Payment [pid=" + pid + ", type=" + type + ", status=" + status + ", booking=" + booking + "]";
//		}

		
		
	}


