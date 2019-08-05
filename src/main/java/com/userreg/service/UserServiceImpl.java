package com.userreg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.userreg.entities.UserEntity;
import com.userreg.model.User;
import com.userreg.repositories.PageableUsersRepository;
import com.userreg.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
    private UserRepository userRepository;
	
	@Autowired
    private PageableUsersRepository pageableUsersRepository;
	
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

	@Override
	public List<User> findAllUsers() {
		
		Iterable<UserEntity> userEntityList = userRepository.findAll();
		List<User> users = new ArrayList<User>();
		
		for (UserEntity entity: userEntityList) {
			User user = new User();
			user.setAddress(entity.getAddress());
			user.setEmail(entity.getEmail());
			user.setFirstname(entity.getFirstname());
			user.setLastname(entity.getLastname());
			user.setMobile(entity.getMobile());
			user.setTelephone(entity.getTelephone());
			user.setUsername(entity.getUsername());
			
			users.add(user);
		}
		
		return users;
	}

	@Override
	public List<User> findAllUsers(int number, int page) {
		
		Pageable pageable = PageRequest.of(page, number, Sort.by(Sort.Direction.ASC, "id"));
		Page<UserEntity> userEntityList = pageableUsersRepository.findAll(pageable);
		List<User> users = new ArrayList<User>();
		
		for (UserEntity entity: userEntityList) {
			User user = new User();
			user.setAddress(entity.getAddress());
			user.setEmail(entity.getEmail());
			user.setFirstname(entity.getFirstname());
			user.setLastname(entity.getLastname());
			user.setMobile(entity.getMobile());
			user.setTelephone(entity.getTelephone());
			user.setUsername(entity.getUsername());
			
			users.add(user);
		}
		
		return users;
	}
}
