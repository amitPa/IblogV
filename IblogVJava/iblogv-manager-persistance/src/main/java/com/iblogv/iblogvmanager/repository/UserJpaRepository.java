package com.iblogv.iblogvmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iblogv.iblogvmanager.model.UserEntity;

public interface UserJpaRepository extends JpaRepository<UserEntity,Long> {

	@Query("Select p FROM UserEntity p WHERE p.email=:email AND p.password=:password")
	UserEntity authUser(@Param("email") String email,@Param("password") String password );
	
	@Query("Select p FROM UserEntity p WHERE p.email=:email")
	UserEntity authUser(@Param("email") String email );
	
	@Query("Select p FROM UserEntity p WHERE p.userId=:userId")
	UserEntity findUserById(@Param("userId") String userId);
}
