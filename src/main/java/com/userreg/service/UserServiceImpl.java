package com.userreg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userreg.entities.UserEntity;
import com.userreg.model.User;
import com.userreg.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
    private UserRepository userRepository;
	
	@Override
	public Long register(User user) {
		
		UserEntity entity = new UserEntity();
		entity.setAddress(user.getAddress());
		entity.setEmail(user.getEmail());
		entity.setFirstName(user.getFirstName());
		entity.setLastName(user.getLastName());
		entity.setMobile(user.getMobile());
		entity.setTelephone(user.getTelephone());
		entity.setUserName(user.getUserName());
		
		entity = userRepository.save(entity);
		return entity.getUserId();
	}

}
