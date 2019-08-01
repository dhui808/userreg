package com.userreg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.userreg.model.User;
import com.userreg.model.UserRegistrationResponse;
import com.userreg.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@Api(value = "UserController", description = "REST Apis for handling user registration.")
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@ApiOperation(value = "Register the user in the System ", response = UserRegistrationResponse.class, tags = "registerUser")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!") })
	@RequestMapping(method = RequestMethod.POST, value="/user/register", produces = "application/json")
	public UserRegistrationResponse registerUser(@RequestBody User user) {
		
		Long userId = userService.register(user);
		UserRegistrationResponse userResponse = new UserRegistrationResponse();
		userResponse.setStatus("success");
		userResponse.setUserId(userId);
		System.out.println("registerUser called - userId = " + userId);
		
		return userResponse;
	}
}
