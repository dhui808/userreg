package com.userreg.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.userreg.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
	
	/*
     * Get user by user name.
     */
    List<UserEntity> findByUsername(String username);
    
    void deleteByUsername(String username);
}
