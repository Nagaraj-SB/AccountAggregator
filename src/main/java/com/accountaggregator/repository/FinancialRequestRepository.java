package com.accountaggregator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accountaggregator.entity.FinancialRequestEntity;

public interface FinancialRequestRepository extends JpaRepository<FinancialRequestEntity, String> {

}
