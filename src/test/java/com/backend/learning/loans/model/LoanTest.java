package com.backend.learning.loans.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LoanTest {

	@Mock
	private Customer customer;

	@InjectMocks
	private Loan loan;

	@Nested
	class isPersonalLoanAvailable {
		@Test
		void shouldBeAvailableWhenIncomeIsEqualToOrLessThan3000() {
			doReturn(true).when(customer).isIncomeEqualOrLowerThan(3000.00);
			assertTrue(loan.isPersonalLoanAvailable());
		}

		@Test
		void shouldBeAvailableForIncomeBetween3000And5000AgeUnder30AndLocationInSP() {
			doReturn(false).when(customer).isIncomeEqualOrLowerThan(3000.00);
			doReturn(true).when(customer).isIncomeBetween(3000.0, 5000.0);
			doReturn(true).when(customer).isAgeLowerThan(30);
			doReturn(true).when(customer).isFromLocation("SP");
			assertTrue(loan.isPersonalLoanAvailable());
		}
	}

	@Nested
	class isGuaranteedLoanAvailable {
		@Test
		void shouldBeAvailableWhenIncomeIsEqualToOrLessThan3000() {
			doReturn(true).when(customer).isIncomeEqualOrLowerThan(3000.00);
			assertTrue(loan.isGuaranteedLoanAvailable());
		}

		@Test
		void shouldBeAvailableForIncomeBetween3000And5000AgeUnder30AndLocationInSP() {
			doReturn(false).when(customer).isIncomeEqualOrLowerThan(3000.00);
			doReturn(true).when(customer).isIncomeBetween(3000.0, 5000.0);
			doReturn(true).when(customer).isAgeLowerThan(30);
			doReturn(true).when(customer).isFromLocation("SP");
			assertTrue(loan.isGuaranteedLoanAvailable());
		}
	}

	@Nested
	class isConsignmentLoanAvailable {
		@Test
		void shouldBeAvailableWhenIncomeIsEqualToOrGreaterThan5000() {
			doReturn(true).when(customer).isIncomeEqualOrGreaterThan(5000.0);
			assertTrue(loan.isConsignmentLoanAvailable());
		}

		@Test
		void shouldNotBeAvailableWhenIncomeIsLessThan5000() {
			doReturn(false).when(customer).isIncomeEqualOrGreaterThan(5000.0);
			assertFalse(loan.isConsignmentLoanAvailable());
		}
	}

	@Nested
	class getPersonalLoanInterestRate {
		@Test
		void shouldTheInterestRateBe4() {
			doReturn(true).when(customer).isIncomeEqualOrLowerThan(3000.0);
			assertEquals(4.0, loan.getPersonalLoanInterestRate());
		}

		@Test
		void shouldThrowExceptionWhenPersonalLoanIsNotAvailable() {
			doReturn(false).when(customer).isIncomeEqualOrLowerThan(3000.0);
			assertThrows(LoanNotAvailableException.class, () -> loan.getPersonalLoanInterestRate());
		}
	}

	@Nested
	class getGuaranteedLoanInterestRate {
		@Test
		void shouldTheInterestRateBe3() {
			doReturn(true).when(customer).isIncomeEqualOrLowerThan(3000.0);
			assertEquals(3.0, loan.getGuaranteedLoanInterestRate());
		}

		@Test
		void shouldThrowExceptionWhenGuaranteedLoanIsNotAvailable() {
			doReturn(false).when(customer).isIncomeEqualOrLowerThan(3000.0);
			assertThrows(LoanNotAvailableException.class, () -> loan.getGuaranteedLoanInterestRate());
		}
	}

	@Nested
	class getConsignmentLoanInterestRate {
		@Test
		void shouldTheInterestRateBe2() {
			doReturn(true).when(customer).isIncomeEqualOrGreaterThan(5000.0);
			assertEquals(2.0, loan.getConsignmentLoanInterestRate());
		}

		@Test
		void shouldThrowExceptionWhenConsignmentLoanIsNotAvailable() {
			doReturn(false).when(customer).isIncomeEqualOrGreaterThan(5000.0);
			assertThrows(LoanNotAvailableException.class, () -> loan.getConsignmentLoanInterestRate());
		}
	}
}
