package com.userreg.service;

import com.userreg.model.User;

public interface UserService {

	Long register(User user);

	User findByUsername(String username);
	
	Long update(User user);
	
	void deleteByUsername(String username);
}
