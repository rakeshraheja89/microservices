package com.interview.springboot.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.springboot.microservice.model.BankFinance;
import com.interview.springboot.microservice.service.BankFinanceService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/bank")
public class SpringBootRestController {
	
	@Autowired
	BankFinanceService bankFinanceService;

	@Operation(summary = "/info/version")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "/info/version ") })
	@GetMapping("/info/version")
	public String checkVersion() {
		return "Greetings from Spring Boot!";
	}
	
	@GetMapping("/getAllData")
	public List<BankFinance> getBankData() {
		return bankFinanceService.getBankData();
	}
	
	@GetMapping("/getData/{financeId}")
	public BankFinance getBankDataById(@PathVariable("financeId") long financeId) {
		return bankFinanceService.getBankDataById(financeId);
	}
	
	@PostMapping("/insert")
	public String insertBankData(@RequestBody BankFinance bankFinance) {
		return bankFinanceService.insertBankData(bankFinance);
	}
	
	@PutMapping("/update")
	public String updateBankData(@RequestBody BankFinance bankFinance) {
		return bankFinanceService.updateBankData(bankFinance);
	}
	
	@PatchMapping("/patch")
	public String patchBankData() {
		return bankFinanceService.patchBankData();
	}
	
	@DeleteMapping("/delete/{financeId}")
	public String deleteBankData(@PathVariable("financeId") int financeId) {
		return bankFinanceService.deleteBankFinanceData(financeId);
	}
	
}
