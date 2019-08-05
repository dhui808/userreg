package com.userreg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		entity.setFirstname(user.getFirstname());
		entity.setLastname(user.getLastname());
		entity.setMobile(user.getMobile());
		entity.setTelephone(user.getTelephone());
		entity.setUsername(user.getUsername());
		
		entity = userRepository.save(entity);
		return entity.getId();
	}

	@Override
	public User findByUsername(String username) {

		List<UserEntity> userEntityList = userRepository.findByUsername(username);
		
		if (null == userEntityList || 0 == userEntityList.size()) {
			System.out.println("User not found:" + username);
			return null; //not found
		}
		
		
		UserEntity entity = userEntityList.get(0);
		
		User user = new User();
		user.setAddress(entity.getAddress());
		user.setEmail(entity.getEmail());
		user.setFirstname(entity.getFirstname());
		user.setLastname(entity.getLastname());
		user.setMobile(entity.getMobile());
		user.setTelephone(entity.getTelephone());
		user.setUsername(entity.getUsername());
		
		return user;
	}
	
	@Override
	public Long update(User user) {
		
		List<UserEntity> userEntityList = userRepository.findByUsername(user.getUsername());
		
		if (null == userEntityList || 0 == userEntityList.size()) {
			return -1l; //not found
		}
		
		System.out.println("User found.");
		UserEntity entity = userEntityList.get(0);
		entity.setAddress(user.getAddress());
		entity.setEmail(user.getEmail());
		entity.setFirstname(user.getFirstname());
		entity.setLastname(user.getLastname());
		entity.setMobile(user.getMobile());
		entity.setTelephone(user.getTelephone());
		entity.setUsername(user.getUsername());
		
		entity = userRepository.save(entity);
		return entity.getId();
	}

	@Transactional
	@Override
	public void deleteByUsername(String username) {
		
		userRepository.deleteByUsername(username);
	}
}
