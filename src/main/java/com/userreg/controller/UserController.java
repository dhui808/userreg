package com.userreg.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.userreg.exception.InvalidCredentialException;
import com.userreg.model.User;
import com.userreg.model.UserAuthenticateResponse;
import com.userreg.model.UserDeleteResponse;
import com.userreg.model.UserRegistrationResponse;
import com.userreg.model.UserRetrieveResponse;
import com.userreg.model.UserUpdateResponse;
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
	
	@ApiOperation(value = "Finds the user by username in the System ", response = UserRetrieveResponse.class, tags = "findByUsername")
    @RequestMapping(method = RequestMethod.POST, value = "/user/findByUsername", produces = "application/json")
    public UserRetrieveResponse findByUsername(@RequestBody Map<String, String> map) {

		String username = map.get("username");
        User user = userService.findByUsername(username);
        System.out.println("username:" + username);
        System.out.println("user:" + user);
        UserRetrieveResponse res = new UserRetrieveResponse();
        if (null != user) {
        	res.setStatus("success");
        	res.setUser(user);
        } else {
        	res.setStatus("failed");
        }
        
        return res;
    }
    
	@ApiOperation(value = "Update the user in the System ", response = UserUpdateResponse.class, tags = "updateUser")
	@RequestMapping(method = RequestMethod.POST, value="/user/update", produces = "application/json")
	public UserUpdateResponse updateUser(@RequestBody User user) {
		
		Long userId = userService.update(user);
		UserUpdateResponse userResponse = new UserUpdateResponse();
		if (userId < 0) {
			userResponse.setStatus("failed");
		} else {
			userResponse.setStatus("success");
		}
		userResponse.setUserId(userId);
		System.out.println("updateUser called - userId = " + userId);
		
		return userResponse;
	}
	
	@ApiOperation(value = "Delete the user from the System ", response = UserDeleteResponse.class, tags = "deleteUser")
	@DeleteMapping("/user/{username}")
	public UserDeleteResponse deleteUser(@PathVariable String username) {
		
		Long id = null;
		try {
			id = Long.parseLong(username);
		} catch (NumberFormatException e) {
			System.out.println(" delete by username instead of id");
		}
		
		if (null == id ) {
			userService.deleteByUsername(username);
		} else {
			userService.deleteByUserId(id);
		}
		
		UserDeleteResponse res = new UserDeleteResponse();
		res.setStatus("success");
		
		return res;
	}
	
	@ApiOperation(value = "Authenticate the user in the System ", response = UserAuthenticateResponse.class, tags = "authenticate")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!") })
	@RequestMapping(method = RequestMethod.POST, value="/user/authenticate", produces = "application/json")
	public UserAuthenticateResponse authenticate(@RequestBody Map<String, String> map) {
		
		String username = map.get("username");
		String password = map.get("password");
		
		UserAuthenticateResponse userResponse = new UserAuthenticateResponse();
		
		try {
			User user = userService.authenticate(username, password);
			BeanUtils.copyProperties(user, userResponse);
		} catch (InvalidCredentialException e) {
			System.out.println("Invalid username  or password.");
			userResponse.setStatus("failed");
			return userResponse;
		}
		
		userResponse.setStatus("success");
		System.out.println("Authentication successful for " + username);
		
		return userResponse;
	}
}
