package com.userreg.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.userreg.model.User;
import com.userreg.model.UsersRetrieveMapResponse;
import com.userreg.model.UsersRetrieveResponse;
import com.userreg.service.PageableUsersService;
import com.userreg.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "UsersController", description = "REST Apis for handling users related operations.")
@RestController
public class UsersController {
	
	@Autowired
	private PageableUsersService pageableUsersService;
	
	@ApiOperation(value = "Find all users in the System ", response = UsersRetrieveResponse.class, tags = "findAllUsers")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!") })
	@RequestMapping(method = RequestMethod.POST, value="/users/findAll", produces = "application/json")
	public UsersRetrieveResponse findAllUsers() {
		
		List<User> users = pageableUsersService.findAllUsers();
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
		List<User> users = pageableUsersService.findAllUsers(number, page);
		UsersRetrieveResponse usersResponse = new UsersRetrieveResponse();
		usersResponse.setStatus("success");
		usersResponse.setUsers(users);
		
		return usersResponse;
	}
	
	@ApiOperation(value = "Find all users in the System with the specified number and page", response = UsersRetrieveResponse.class, tags = "findAllPageableWithSelectedColumns")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!") })
	@RequestMapping(method = RequestMethod.POST, value="/users/findAllPageableWithSelectedColumns", produces = "application/json")
	public UsersRetrieveMapResponse findAllPageableWithSelectedColumns(@RequestBody Map<String, Object> map) {
		
		List<String> list = (List<String>)map.get("columns");
		String[] columns = list.toArray(new String[list.size()]);
		int number = (Integer)map.get("number");
		int page = (Integer)map.get("page");
		List<Map<String, String>> users = pageableUsersService.findAllUsers(columns, number, page);
		UsersRetrieveMapResponse usersResponse = new UsersRetrieveMapResponse();
		usersResponse.setStatus("success");
		usersResponse.setUsers(users);
		
		return usersResponse;
	}
}
