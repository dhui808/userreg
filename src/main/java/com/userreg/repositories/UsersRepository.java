package com.userreg.repositories;

import org.springframework.data.repository.CrudRepository;

import com.userreg.entities.UserEntity;

public interface UsersRepository extends CrudRepository<UserEntity, Long> {
}
