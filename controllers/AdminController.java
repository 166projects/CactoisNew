package com.mphasis.car.controllers;

import com.mphasis.car.bo.LocationBo;
import com.mphasis.car.entities.Location;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.car.bo.AdminBo;
import com.mphasis.car.bo.Bookingbo;
import com.mphasis.car.bo.DriverBo;
import com.mphasis.car.bo.HelpDeskBo;
import com.mphasis.car.bo.PaymentBo;
import com.mphasis.car.bo.UserBo;
import com.mphasis.car.bo.VehicleBo;
import com.mphasis.car.entities.Booking;
import com.mphasis.car.entities.Driver;
import com.mphasis.car.entities.HelpDesk;
import com.mphasis.car.entities.Payment;
import com.mphasis.car.entities.User;
import com.mphasis.car.entities.Vehicle;
import com.mphasis.car.exception.BuisnessException;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminBo adminBo;
	 @Autowired
	 PaymentBo paymentBo;
	@Autowired
	UserBo userBo;
	@Autowired
	DriverBo driverBo;
	 @Autowired
	Bookingbo bookingbo;
      @Autowired
 	HelpDeskBo helpDeskBo;
      @Autowired
  	VehicleBo vehicleBo;
      @Autowired
      LocationBo locationBo;
//locatio stared
      
      //location ended
  	//Vehicle Operations Started
  	@RequestMapping(value="/addvehicle", method=RequestMethod.POST,
  			produces=MediaType.APPLICATION_JSON_VALUE)
  	public void addVehicle(@RequestBody Vehicle vehicle)
  	{
  		vehicleBo.insertVehicle(vehicle);
  	}
  	
  	
  	@RequestMapping(value="/updatevehicle", method=RequestMethod.PUT,
  			produces=MediaType.APPLICATION_JSON_VALUE)
  	public void updateVehicle(@RequestBody Vehicle vehicle) 
  	{
  		Vehicle v=vehicleBo.getVechicleByNo(vehicle.getVno());
  	if(v!=null)
  		vehicleBo.updateVehicle(vehicle);
  	else
  		vehicleBo.insertVehicle(vehicle);
  	}
  	
  	@RequestMapping(value="/vehicleno/{vno}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
  	public Vehicle getVehicleById(@PathVariable("vno") String vno) {
  		return vehicleBo.getVechicleByNo(vno);
  	}
  	@RequestMapping(value="/vehicletype/{vtype}", 
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Vehicle> getVehicleByType(@PathVariable("vtype") String vtype) {
		return vehicleBo.getVehicleByType(vtype);
	}
	
	@RequestMapping(value="/vehicledelete/{vno}", method=RequestMethod.DELETE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public void deleteVehicle(@PathVariable("vno") String vno) {
		vehicleBo.deleteVehicle(vno);
	}
	
	@RequestMapping(value="/allvehicles", method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Vehicle> getAllVehicles()
	{
	
		return vehicleBo.getAllVehicles();
	}
	//  vehicle operations Completed
	
	//Driver Operation start
	
      @RequestMapping(value="/drivergetall",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)

      public  List<Driver> getAll(){

            /* try {

                   

                    if(driver.isEmpty())

                          return  new ResponseEntity<List<Driver>>(HttpStatus.NO_CONTENT);

                   

             } catch (Exception e) {

                   

                      return new ResponseEntity<List<Driver>>(HttpStatus.NOT_ACCEPTABLE);

             }

             return new ResponseEntity<List<Driver>>(HttpStatus.OK);*/
 
    	  List<Driver> driver =null;
		try {
			driver = driverBo.getDrivers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	  return driver;


      }

     

@RequestMapping(value="/drivergetById/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)

      public  Driver getDriverById(@PathVariable("id") String id){

	Driver driver =null;    
	    try {
               driver = driverBo.getDriverById(id);
             } catch (Exception e)
	         {

             }
              return driver;
}

     

     

@RequestMapping(value="/driverupdate",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)

      public  void updateDriver(@RequestBody Driver driver)
            {
                driverBo.updateDriver(driver);
            }

@RequestMapping(value="/driverdelete/{id}",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)

      public  void deleteDriver(@PathVariable("id") String id){

             driverBo.deleteDriver(id);

             
             }
//Driver Operations completed

//Complaints operation Started
      @RequestMapping(value="/deletecomplaint/{hid}", method=RequestMethod.DELETE,
  	produces=MediaType.APPLICATION_JSON_VALUE)
  	public void deleteComplaint(@PathVariable("hid")String hid)
  	{
  		helpDeskBo.removeComplaint(hid);
  	}

      
      
     
      
	 @RequestMapping(value="/allcomplaints", method=RequestMethod.GET,
				produces=MediaType.APPLICATION_JSON_VALUE)
		public List<HelpDesk> getAllComplaints()
		{
			return helpDeskBo.getAllComplaints();
		}
		
		@RequestMapping(value="/usercomplaints", method=RequestMethod.GET,
				produces=MediaType.APPLICATION_JSON_VALUE)
		public List<HelpDesk> getUserComplaints()
		{
			return helpDeskBo.getUserComplaints();
		}
		
		@RequestMapping(value="/drivercomplaints", method=RequestMethod.GET,
				produces=MediaType.APPLICATION_JSON_VALUE)
		public List<HelpDesk> getDriverComplaints()
		{
			return helpDeskBo.getDriverComplaints();
		}
		
		//Complaints operation Completed		

//	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
//	public List<User> getAll()
//	{
//		return adminBo.get();
//	}
		//Admin operation started
	@RequestMapping(value="/Admindelete/{id}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public void deleteAdmin(@PathVariable("id")String id) throws BuisnessException
	{ 
		adminBo.deleteAdmin(id);
	}
	//Admin operation started
	
	//User operation started
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

	@RequestMapping(value="/users",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public  List<User> getUsers()  {
	 List<User> user=userBo.getUser();
	  return user;
	}
	
	//User operation completed
	
	//Booking operation started
		 @RequestMapping(value="/allbookings",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	  public  List<Booking> getAllbookings()
	  {
	 return bookingbo.getBookings();
	  }
	 @RequestMapping(value="/addbooking",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	  public   void addbooking(@RequestBody Booking booking)
	  {
	 
	  bookingbo.addBooking(booking);
	   
	  }
	@RequestMapping(value="/getbooking/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public   Booking getbookingwithid(@PathVariable("id") String id)
	{
	  return bookingbo.getBookingById(id);   
	} 

	//Bookings operation completed
	//payment started
	 @RequestMapping(value="/paymentdelete/{id}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	  public  void deleteUser(@PathVariable("id") String id) 
	  {
	    try 
	    {
		  paymentBo.deletePayment(id);
       }
	    catch(Exception e) 
	    {
	      e.printStackTrace();  
	    }
	  }
	  @RequestMapping(value="/allPayment", method=RequestMethod.GET,
				produces=MediaType.APPLICATION_JSON_VALUE)
		public List<Payment> getAllPayment()
		{
			return paymentBo.getPayments();
		}
	  @RequestMapping(value="/PaymentId/{id}", method=RequestMethod.GET,
				produces=MediaType.APPLICATION_JSON_VALUE)
		public Payment getPaymentId(@PathVariable("id") String id)
		{
			return paymentBo.getPaymentById(id);
		}
   //payment Ended
}
