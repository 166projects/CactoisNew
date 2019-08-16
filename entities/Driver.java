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
@Entity(name="cabDriver")
public class Driver implements Serializable {
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
            					                   @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "D"),
            					                   @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d")})

                private String did;
                @Column(nullable=false)
                private String dname;
                @Column(nullable=false)
                private int dphno;
                @Column(nullable=false)
                private String dpass;
                @Column(nullable=false)
                private String daddrno;
                @Column(nullable=false)
                private int drating;
                @Column(nullable=false)
                private String demail;
                @Column(nullable=false)
                private int drides;
                public String getDemail() {
					return demail;
				}
				public void setDemail(String demail) {
					this.demail = demail;
				}
				@Column(nullable=false)
            	private String Permanent_Address;
            	@Column(nullable=false)
            	private String current_Address;
                @Column(nullable=false)
                private int dsalary;
                @OneToMany(mappedBy="driver",fetch=FetchType.LAZY)
                @JsonIgnore
                private List<HelpDesk> helpDesk;
                private String dlicence;
                
								public String getDaddrno() {
					return daddrno;
				}
				public void setDaddrno(String daddrno) {
					this.daddrno = daddrno;
				}
				public String getPermanent_Address() {
					return Permanent_Address;
				}
				public void setPermanent_Address(String permanent_Address) {
					Permanent_Address = permanent_Address;
				}
				public String getCurrent_Address() {
					return current_Address;
				}
				public void setCurrent_Address(String current_Address) {
					this.current_Address = current_Address;
				}
				public String getDlicence(){
					 return dlicence;
				}
								public void setDlicence(String dlicence){
								this.dlicence=dlicence;
								}
								                
								public String getDid() {
								                return did;
								}
								public void setDid(String did) {
								                this.did = did;
								}
								public String getDname() {
								                return dname;
								}
								public void setDname(String dname) {
								                this.dname = dname;
								}
								public int getDphno() {
								                return dphno;
								}
								public void setDphno(int dphno) {
								                this.dphno = dphno;
								}
								 
								public int getDrating() {
								                return drating;
								}
								public void setDrating(int drating) {
								                this.drating = drating;
								}
								public int getDrides() {
								                return drides;
								}
								public void setDrides(int drides) {
								                this.drides = drides;
								}
								public int getDsalary() {
								                return dsalary;
								}
								public void setDsalary(int dsalary) {
								                this.dsalary = dsalary;
								}
								
								/*public Vehicle getVehicle() {
								                return vehicle;
								}
								public void setVehicle(Vehicle vehicle) {
								                this.vehicle = vehicle;
								}*/
								
								
								
								//@Override
								//public String toString() {
								//            return "Driver [did=" + did + ", dname=" + dname + ", dphno=" + dphno + ", dadno=" + dadno + ", drating=" + drating
								//                                            + ", drides=" + drides + ", dsalary=" + dsalary + ",dlicence"+dlicence +"vehicle=" + " " + " ]";
								//}
								
								public String getDpass() {
								                return dpass;
								}
								public void setDpass(String dpass) {
								                this.dpass = dpass;
								}
								public List<HelpDesk> getHelpDesk() {
								                return helpDesk;
								}
								public void setHelpDesk(List<HelpDesk> helpDesk) {
								                this.helpDesk = helpDesk;
								}
								

}
