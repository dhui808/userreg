package com.userreg.service;

import java.util.List;

import com.userreg.model.User;

public interface PageableUsersService {
	
	List<User> findAllUsers();
	List<User> findAllUsers(int number, int page);
}
