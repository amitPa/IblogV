package com.iblogv.iblogvmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iblogv.iblogvmanager.model.BlogEntity;

public interface BlogJpaRepository extends JpaRepository<BlogEntity, Long> {

}
