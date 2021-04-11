package com.bank.favorite.payee.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.favorite.payee.model.FavoritePayee;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/favorite/payee")
public class FavoritePayeeController {
	
	@Operation(summary = "/info/version")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "/info/version ") })
	@GetMapping("/info/version")
	public String checkVersion() {
		return "Greetings from Spring Boot!";
	}
	
	@PostMapping("/login")
	public void login() {
	}
	
	@PostMapping("/create")
	public String insertBankData() {
		return null;
	}
	
	@PutMapping("/update")
	public String updateBankData() {
		return null;
	}
	
	@DeleteMapping("/delete")
	public String deleteBankData() {
		return null;
	}
	
}
