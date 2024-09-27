package com.backend.learning.loans.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.learning.loans.dto.CustomerLoanRequest;
import com.backend.learning.loans.dto.CustomerLoanResponse;
import com.backend.learning.loans.service.LoanService;

import jakarta.validation.Valid;

@RestController
public class LoanController {

	private final LoanService loanService;

	public LoanController(LoanService loanService) {
		this.loanService = loanService;
	}

	@PostMapping(value = "/customer-loans")
	public ResponseEntity<CustomerLoanResponse> customerLoans(@RequestBody @Valid CustomerLoanRequest request) {

		var loanResponse = loanService.checkLoanAvailability(request);

		return ResponseEntity.ok(loanResponse);
	}
}
