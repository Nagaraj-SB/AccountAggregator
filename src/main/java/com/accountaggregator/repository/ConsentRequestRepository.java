package com.accountaggregator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accountaggregator.entity.ConsentRequestEntity;

public interface ConsentRequestRepository extends JpaRepository<ConsentRequestEntity, String> {

}
