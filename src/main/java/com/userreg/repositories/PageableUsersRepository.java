package com.userreg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userreg.entities.UserEntity;

public interface PageableUsersRepository extends  JpaRepository<UserEntity, Long> {
}
