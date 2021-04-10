
package com.interview.springboot.microservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.springboot.microservice.exception.BankRuntimeException;
import com.interview.springboot.microservice.model.BankFinance;
import com.interview.springboot.microservice.repository.BankFinanceRepository;

@Service
public class BankFinanceServiceImpl implements BankFinanceService {

	@Autowired
	BankFinanceRepository bankFinanceRepository;

	@Override
	public List<BankFinance> getBankData() {
		List<BankFinance> bankFinances = new ArrayList<BankFinance>();
		bankFinanceRepository.findAll().forEach(bankFinance->bankFinances.add(bankFinance));
		if(bankFinances.size() > 0) {
            return bankFinances;
        } else {
            return new ArrayList<BankFinance>();
        }
	}
	
	@Override
	public BankFinance getBankDataById(Long id) throws BankRuntimeException 
    {
        Optional<BankFinance> bankFinance = bankFinanceRepository.findById(id);
         
        if(bankFinance.isPresent()) {
            return bankFinance.get();
        } else {
            throw new BankRuntimeException("No bankFinance record exist for given id");
        }
    }

	public BankFinance createOrUpdateEmployee(BankFinance bankFinance) throws BankRuntimeException 
    {
        Optional<BankFinance> bankFinanceObj = bankFinanceRepository.findById(bankFinance.getId());
         
        if(bankFinanceObj.isPresent()) 
        {
            BankFinance newEntity = bankFinanceObj.get(); 
			/*
			 * newEntity.setEmail(entity.getEmail());
			 * newEntity.setFirstName(entity.getFirstName());
			 * newEntity.setLastName(entity.getLastName());
			 */
 
            newEntity = bankFinanceRepository.save(newEntity);
             
            return newEntity;
        } else {
        	bankFinance = bankFinanceRepository.save(bankFinance);
             
            return bankFinance;
        }
    } 
	
	@Override
	public String insertBankData(BankFinance bankFinance) {
		return null;
	}

	@Override
	public String updateBankData(BankFinance bankFinance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String patchBankData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteBankFinanceData(int financeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
