package com.mphasis.car.controllers;
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
import com.mphasis.car.bo.DriverBo;
import com.mphasis.car.bo.HelpDeskBo;
import com.mphasis.car.bo.VehicleBo;
import com.mphasis.car.entities.Driver;
import com.mphasis.car.entities.HelpDesk;
import com.mphasis.car.entities.Vehicle;

 

@RestController
@RequestMapping("/drivers")
public class DriverController {

       @Autowired

       DriverBo driverBo;

       @Autowired
   	HelpDeskBo helpDeskBo;
       @Autowired
   	VehicleBo vehicleBo;
       @RequestMapping(value="/addcomplaint", method=RequestMethod.POST,
   			produces=MediaType.APPLICATION_JSON_VALUE)
   	public void addCompplaint(@RequestBody HelpDesk helpDesk)
   	{
   		helpDeskBo.insertComplaint(helpDesk);
   	}


      

@RequestMapping(value="/drivergetById/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)

       public  Driver getDriverById(@PathVariable("id") String id){

     Driver driver =null;         
	try {

                     driver = driverBo.getDriverById(id);

              } catch (Exception e) {

                     

              }

             

              return  driver;

             

       }

      

      

@RequestMapping(value="/driverupdate",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)

       public  void updateDriver(@RequestBody Driver driver){

              driverBo.updateDriver(driver);
 }

@RequestMapping(value="/driverdelete/{id}",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)

       public  void deleteDriver(@PathVariable("id") String id){

               driverBo.deleteDriver(id);

              

              }

      

@RequestMapping(value="/driverlogin/{demail}/{pass}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)

public Driver login(@PathVariable("demail") String demail,@PathVariable("pass") String dpass){
Driver driver =null; 
       try {

             return driverBo.login(demail, dpass);

       } catch (Exception e) {      
    	   e.printStackTrace();
       }
       //System.out.println(driver);
      return driver;  
}







@RequestMapping(value="/changepassword/{id}/{oldpass}/{newpass}",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)

public  void changepassword(@PathVariable("id") String did,@PathVariable("oldpass") String oldpass,@PathVariable("newpass") String newpass){

       try {

              driverBo.changepassword(did,oldpass, newpass);

       } catch (Exception e) {

                
       }

       

}

      

 

@RequestMapping(value="/driveradd",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)

       public  void signup(@RequestBody Driver driver){

              try {

                     driverBo.signup(driver);

              } catch (Exception e) {

                        

              }

              

       }

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

@RequestMapping(value="/vehicleno/{vno}", 
method=RequestMethod.GET,
produces=MediaType.APPLICATION_JSON_VALUE)
public Vehicle getVehicleById(@PathVariable("vno")String vno) {
return vehicleBo.getVechicleByNo(vno);
}

@RequestMapping(value="/deletevehicle/{vno}", method=RequestMethod.DELETE,
produces=MediaType.APPLICATION_JSON_VALUE)
public void deleteVehicle(@PathVariable("vno")String vno) {
vehicleBo.deleteVehicle(vno);
}  

}

 