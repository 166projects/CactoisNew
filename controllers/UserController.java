//Bhuma Pravallika
package com.mphasis.car.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import com.mphasis.car.bo.Bookingbo;
import com.mphasis.car.bo.HelpDeskBo;
import com.mphasis.car.bo.LocationBo;
import com.mphasis.car.bo.PaymentBo;
import com.mphasis.car.bo.UserBo;
import com.mphasis.car.bo.VehicleBo;
import com.mphasis.car.entities.Booking;
import com.mphasis.car.entities.HelpDesk;
import com.mphasis.car.entities.Payment;
import com.mphasis.car.entities.User;
import com.mphasis.car.entities.Vehicle;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserBo userBo;
	@Autowired
	Bookingbo bookingbo;
	@Autowired
	HelpDeskBo helpDeskBo;
	@Autowired
	VehicleBo vehicleBo;
	 @Autowired
	 PaymentBo paymentBo;
	 @Autowired
	 LocationBo locationBo;
	@RequestMapping(value="/addcomplaint", method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public void addCompplaint(@RequestBody HelpDesk helpDesk)
	{
		helpDeskBo.insertComplaint(helpDesk);
	}
	 @RequestMapping(value="/addbooking",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	  public   void addbooking(@RequestBody Booking booking)
	  {
		 System.out.println("Controller called"+ booking.getDestination());
		 bookingbo.addBooking(booking);
	  } 
	 @RequestMapping(value="/updatebooking",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	  public    void  updatebooking(@RequestBody Booking booking)
	  {
		 Booking book =  bookingbo.getBookingById(booking.getBid());
		 if(book!=null)
		{
			bookingbo.updateBooking(book);
	    }
		else
		{
			bookingbo.addBooking(book);
		}
	  }
	 @RequestMapping(value="/fare/{type}/{source}/{dest}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	 public  int calcifare(@PathVariable("type") String type,@PathVariable("source") String source,@PathVariable("dest") String dest) 
	 {
	     System.out.println("Contriller called");
	     int fare =0;
		 try 
		 {
			  fare = locationBo.calcfare(type, source, dest);
	     }
		 catch(Exception e)
	    {
	         e.printStackTrace();
	    }
		 return fare;
	  }
	 @RequestMapping(value="/userupdate",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	 public  void updateUser(@RequestBody User user) {
	  System.out.println("Contriller called");
		 try {
	   userBo.updateuser(user);
	  }catch(Exception e)
	  {
	   e.printStackTrace();
	  }
	  }

	 @RequestMapping(value="/userdelete/{id}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	 public  void deleteUser(@PathVariable("id") String id) {
	  try {
	   userBo.deleteuser(id);
	  }catch(Exception e) {
	    
	  }
	  
	 }

	 @RequestMapping(value="/userlogin/{email}/{pass}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
     public User login(@PathVariable("email") String uemail,@PathVariable("pass") String upass) {
       User user=null;
            try {
            	
       return userBo.login(uemail, upass);
       }catch(Exception e) {
         e.printStackTrace();
       }
                  return user;
    
     }

     @RequestMapping(value="/userchangepassword/{id}/{oldpass}/{newpass}",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
     public void changepassword(@PathVariable("id") String cid,@PathVariable("oldpass") String oldpass,@PathVariable("newpass") String newpass) {
       try {
        userBo.changepassword(cid,oldpass,newpass);
       }catch(Exception e) {
              e.printStackTrace();
       }
        
      }


	 @RequestMapping(value="/usersignup",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	 public  void signup(@RequestBody User user) 
	 {
	  try {
	   userBo.signup(user);
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
	   
	 }

	 @RequestMapping(value="/userbyid/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
		public User getUsersById(@PathVariable("id") String id) {
		    User user =null;
			try {
		  user=userBo.getUsersById(id);
		 }catch(Exception e) {
		   
		 }
		  return user;
		}
	 @RequestMapping(value="/userbyname/{name}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
		public List<User> getUsersByName(@PathVariable("name") String name) {
		    List<User> users = null;
			try {
		  users = userBo.getUsersByName(name);
		 }catch(Exception e) {
		  
		 }
		 return users;
		}

	 @RequestMapping(value="/vehicleLoc/{current_location}", 
				method=RequestMethod.GET,
				produces=MediaType.APPLICATION_JSON_VALUE)
		public List<Vehicle> getVehicleByLocation(@PathVariable("current_location")String current_location) {
			return vehicleBo.getVehicleByLocation(current_location);
		}
		
		@RequestMapping(value="/vehicletype/{vtype}", 
				method=RequestMethod.GET,
				produces=MediaType.APPLICATION_JSON_VALUE)
		public List<Vehicle> getVehicleByType(@PathVariable("vtype")String vtype) {
			return vehicleBo.getVehicleByType(vtype);
		}
		
		@RequestMapping(value="/allvehicles", method=RequestMethod.GET,
				produces=MediaType.APPLICATION_JSON_VALUE)
		public List<Vehicle> getAllVehicles()
		{
			return vehicleBo.getAllVehicles();
		}
		
		@RequestMapping(value="/addPayment", method=RequestMethod.POST,
				produces=MediaType.APPLICATION_JSON_VALUE)
		public void addPayment(@RequestBody Payment payment )
		{
                 paymentBo.addPayment(payment);
		}
	    @RequestMapping(value="/updatepayment",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	    public    void  updatebooking(@RequestBody Payment payment)
	    {
		 Payment pay = paymentBo.getPaymentById(payment.getPid()); 
		 if(pay!=null)
		{
			 
			paymentBo.updatePayment(pay); 
		}
		else
		{
			paymentBo.addPayment(payment);
		}
	  }
	 }
	 

