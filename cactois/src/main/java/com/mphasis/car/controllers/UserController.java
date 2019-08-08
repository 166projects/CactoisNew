//Bhuma Pravallika
package com.mphasis.car.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mphasis.car.bo.UserBo;
import com.mphasis.car.entities.User;

@Controller
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	UserBo userBo;
	
	@RequestMapping(value="/users",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public void updateUser(@RequestBody User user) {
				
	}
}
