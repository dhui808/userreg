package com.userreg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.userreg.model.User;
import com.userreg.model.UserRegistrationResponse;
import com.userreg.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.POST, value="/user/register")
	public UserRegistrationResponse registerUser(@RequestBody User user) {
		
		Long userId = userService.register(user);
		UserRegistrationResponse userResponse = new UserRegistrationResponse();
		userResponse.setStatus("success");
		userResponse.setUserId(userId);
		System.out.println("registerUser called - userId = " + userId);
		
		return userResponse;
	}
}
