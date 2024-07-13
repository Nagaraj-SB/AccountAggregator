package com.accountaggregator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accountaggregator.entity.FinancialInformationEntity;

public interface FinancialInformationRepository extends JpaRepository<FinancialInformationEntity, String> {

}
