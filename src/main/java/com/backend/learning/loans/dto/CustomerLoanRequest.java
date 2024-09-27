package com.backend.learning.loans.dto;

import org.hibernate.validator.constraints.br.CPF;

import com.backend.learning.loans.model.Customer;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CustomerLoanRequest(@Min(value = 18) @NotNull Integer age, @CPF String cpf, @NotBlank String name,
		@Min(value = 1000) @NotNull Double income, @NotBlank String location) {

	public Customer toCustomer() {
		return new Customer(age, cpf, name, income, location);
	}
}
