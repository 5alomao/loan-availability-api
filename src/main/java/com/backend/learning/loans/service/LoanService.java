package com.backend.learning.loans.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.learning.loans.dto.CustomerLoanRequest;
import com.backend.learning.loans.dto.CustomerLoanResponse;
import com.backend.learning.loans.dto.LoanResponse;
import com.backend.learning.loans.model.Loan;
import com.backend.learning.loans.model.LoanType;

@Service
public class LoanService {

	public CustomerLoanResponse checkLoanAvailability(CustomerLoanRequest request) {

		var customer = request.toCustomer();

		var loan = new Loan(customer);

		List<LoanResponse> loans = new ArrayList<>();

		if (loan.isPersonalLoanAvailable()) {
			loans.add(new LoanResponse(LoanType.PERSONAL, loan.getPersonalLoanInterestRate()));
		}

		if (loan.isConsignmentLoanAvailable()) {
			loans.add(new LoanResponse(LoanType.CONSIGNMENT, loan.getConsignmentLoanInterestRate()));
		}

		if (loan.isGuaranteedLoanAvailable()) {
			loans.add(new LoanResponse(LoanType.GUARANTEED, loan.getGuaranteedLoanInterestRate()));
		}

		return new CustomerLoanResponse(request.name(), loans);
	}
}
