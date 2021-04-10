package com.interview.springboot.microservice.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.interview.springboot.microservice.model.BankFinance;  

public interface BankFinanceRepository extends CrudRepository<BankFinance, Integer>      {

	Optional<BankFinance> findById(Long id);

	Optional<BankFinance> save(Optional<BankFinance> bankFinance);

}
