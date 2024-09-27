package com.backend.learning.loans.dto;

import com.backend.learning.loans.model.LoanType;

public record LoanResponse(LoanType type, Double interestRate) {

}
