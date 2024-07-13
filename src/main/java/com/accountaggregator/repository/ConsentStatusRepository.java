package com.accountaggregator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accountaggregator.entity.ConsentStatusEntity;

public interface ConsentStatusRepository extends JpaRepository<ConsentStatusEntity, String> {

}
