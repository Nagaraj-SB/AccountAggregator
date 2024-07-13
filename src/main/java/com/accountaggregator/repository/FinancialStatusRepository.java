package com.accountaggregator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accountaggregator.entity.FinancialStatusEnity;

public interface FinancialStatusRepository extends JpaRepository<FinancialStatusEnity, String> {

}
