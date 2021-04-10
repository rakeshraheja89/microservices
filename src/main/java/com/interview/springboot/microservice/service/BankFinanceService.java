package com.interview.springboot.microservice.service;

import java.util.List;

import com.interview.springboot.microservice.exception.BankRuntimeException;
import com.interview.springboot.microservice.model.BankFinance;

public interface BankFinanceService {

	List<BankFinance> getBankData();
	
	String insertBankData(BankFinance bankFinance);

	String updateBankData(BankFinance bankFinance);

	String patchBankData();
	
	String deleteBankFinanceData(int financeId);

	BankFinance getBankDataById(Long id) throws BankRuntimeException;

}
