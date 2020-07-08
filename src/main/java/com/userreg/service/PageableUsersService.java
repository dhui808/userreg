package com.userreg.service;

import java.util.List;
import java.util.Map;

import com.userreg.model.User;

public interface PageableUsersService {
	
	List<User> findAllUsers();
	List<User> findAllUsers(int number, int page);
	List<Map<String, String>> findAllUsers(String[] columns, int number, int page) throws RuntimeException;
}
