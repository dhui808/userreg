package com.userreg.repositories;

import org.springframework.data.repository.CrudRepository;

import com.userreg.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

	UserEntity save(UserEntity user);
}
