package com.userreg.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.userreg.model.User;
import com.userreg.model.UserDeleteResponse;
import com.userreg.model.UserRegistrationResponse;
import com.userreg.model.UserRetrieveResponse;
import com.userreg.model.UserUpdateResponse;
import com.userreg.model.UsersRetrieveResponse;
import com.userreg.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@Api(value = "UsersController", description = "REST Apis for handling users related operations.")
@RestController
public class UsersController {

	@Autowired
	private UserService userService;
	
	@ApiOperation(value = "Find all users in the System ", response = UsersRetrieveResponse.class, tags = "findAllUsers")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!") })
	@RequestMapping(method = RequestMethod.POST, value="/users/findAll", produces = "application/json")
	public UsersRetrieveResponse findAllUsers() {
		
		List<User> users = userService.findAllUsers();
		UsersRetrieveResponse usersResponse = new UsersRetrieveResponse();
		usersResponse.setStatus("success");
		usersResponse.setUsers(users);
		
		return usersResponse;
	}
	
	@ApiOperation(value = "Find all users in the System with the specified number and page", response = UsersRetrieveResponse.class, tags = "findAllPageable")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!") })
	@RequestMapping(method = RequestMethod.POST, value="/users/findAllPageable", produces = "application/json")
	public UsersRetrieveResponse findAllPageable(@RequestBody Map<String, String> map) {
		
		int number = Integer.valueOf(map.get("number"));
		int page = Integer.valueOf(map.get("page"));
		List<User> users = userService.findAllUsers(number, page);
		UsersRetrieveResponse usersResponse = new UsersRetrieveResponse();
		usersResponse.setStatus("success");
		usersResponse.setUsers(users);
		
		return usersResponse;
	}
}
