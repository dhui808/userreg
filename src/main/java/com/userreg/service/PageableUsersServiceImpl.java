package com.userreg.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.userreg.entities.UserEntity;
import com.userreg.model.User;
import com.userreg.repositories.PageableUsersRepository;
import com.userreg.repositories.UsersRepository;

@Service
public class PageableUsersServiceImpl implements PageableUsersService {
	
	@Autowired
    private UsersRepository usersRepository;
	
	@Autowired
    private PageableUsersRepository pageableUsersRepository;
	
	@Override
	public List<User> findAllUsers() {
		
		Iterable<UserEntity> userEntityList = usersRepository.findAll();
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
			user.setPassword(entity.getPasswordhash());
			user.setId(entity.getId());
			
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
			user.setPassword(entity.getPasswordhash());
			user.setId(entity.getId());
			
			users.add(user);
		}
		
		return users;
	}
	
	@Override
	public List<Map<String, String>> findAllUsers(String[] columns, int number, int page) throws RuntimeException {
		
		Pageable pageable = PageRequest.of(page, number, Sort.by(Sort.Direction.ASC, "id"));
		Page<UserEntity> userEntityList = pageableUsersRepository.findAll(pageable);
		List<Map<String, String>> users = new ArrayList<Map<String, String>>();
		List<String> list = Arrays.asList(columns);
		
		for (UserEntity entity: userEntityList) {
			Map<String, String> map = new HashMap<String, String>();
			Field[] fields = entity.getClass().getDeclaredFields();
			
			for (Field field: fields) {
				field.setAccessible(true);
				String name = field.getName();
				if (list.contains(name)) {
					String value;
					try {
						value = (String)field.get(entity);
					} catch (IllegalAccessException e) {
						throw new RuntimeException();
					}
					map.put(name, value);
				}
			}

			users.add(map);
		}
		
		return users;
	}
}
