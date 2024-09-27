package com.backend.learning.loans.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.backend.learning.loans.factory.CustomerFactory;

class CustomerTest {

	@Nested
	class isIncomeEqualOrLowerThan {
		@Test
		void shouldBeTrueWhenIncomeIsEqualToValue() {
			Customer customer = CustomerFactory.build(5000.00);
			assertTrue(customer.isIncomeEqualOrLowerThan(5000.0));
		}

		@Test
		void shouldBeTrueWhenIncomeIsLowerThanValue() {
			Customer customer = CustomerFactory.build(3000.00);
			assertTrue(customer.isIncomeEqualOrLowerThan(5000.0));
		}

		@Test
		void shouldBeFalseWhenIncomeIsGreaterThanValue() {
			Customer customer = CustomerFactory.build(8000.00);
			assertFalse(customer.isIncomeEqualOrLowerThan(5000.0));
		}
	}

	@Nested
	class isIncomeEqualOrGreaterThan {
		@Test
		void shouldBeTrueWhenIncomeIsEqualToValue() {
			Customer customer = CustomerFactory.build(5000.00);
			assertTrue(customer.isIncomeEqualOrGreaterThan(5000.00));
		}

		@Test
		void shouldBeTrueWhenIncomeIsGreaterThanValue() {
			Customer customer = CustomerFactory.build(8000.00);
			assertTrue(customer.isIncomeEqualOrGreaterThan(5000.00));
		}

		@Test
		void shouldBeFalseWhenIncomeIsLowerThanValue() {
			Customer customer = CustomerFactory.build(3000.00);
			assertFalse(customer.isIncomeEqualOrGreaterThan(5000.00));
		}
	}

	@Nested
	class isIncomeBetween {
		@Test
		void shouldBeTrueWhenIncomeIsBetween() {
			Customer customer = CustomerFactory.build(4000.00);
			assertTrue(customer.isIncomeBetween(3000.00, 5000.00));
		}

		@Test
		void shouldBeFalseWhenIncomeIsNotBetween() {
			Customer customer = CustomerFactory.build(6000.00);
			assertFalse(customer.isIncomeBetween(3000.00, 5000.00));
		}

		@Test
		void shouldBeTrueWhenIncomeIsEqualToMinValue() {
			Customer customer = CustomerFactory.build(3000.00);
			assertTrue(customer.isIncomeBetween(3000.00, 5000.00));
		}

		@Test
		void shouldBeTrueWhenIncomeIsEqualToMaxValue() {
			Customer customer = CustomerFactory.build(5000.00);
			assertTrue(customer.isIncomeBetween(3000.00, 5000.00));
		}
	}

	@Nested
	class isAgeLowerThan {
		@Test
		void shouldBeTrueWhenAgeIsLowerThanValue() {
			Customer customer = CustomerFactory.build(25);
			assertTrue(customer.isAgeLowerThan(30));
		}

		@Test
		void shouldBeFalseWhenAgeIsEqualToValue() {
			Customer customer = CustomerFactory.build(25);
			assertFalse(customer.isAgeLowerThan(25));
		}

		@Test
		void shouldBeFalseWhenAgeIsGreaterThanValue() {
			Customer customer = CustomerFactory.build(30);
			assertFalse(customer.isAgeLowerThan(25));
		}
	}

	@Nested
	class isFromLocation {
		@Test
		void shouldBeTrueWhenLocationIsEqualToValue() {
			Customer customer = CustomerFactory.build("SP");
			assertTrue(customer.isFromLocation("SP"));
		}

		@Test
		void shouldBeFalseWhenLocationIsNotEqualToValue() {
			Customer customer = CustomerFactory.build("SP");
			assertFalse(customer.isFromLocation("RJ"));
		}
	}
}
