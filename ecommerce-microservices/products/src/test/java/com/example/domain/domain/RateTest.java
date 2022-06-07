package com.example.domain.domain;

import com.example.domain.Rate;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RateTest {

	@Test
	void test_fields() {

		Rate rate = new Rate();
		rate.setBrandId("1");
		rate.setProductId("2");
		rate.setId("3");
		rate.setStartDate(LocalDateTime.of(2020, 1, 1, 10, 0, 0));
		rate.setEndDate(LocalDateTime.of(2022, 2, 2, 22, 0, 0));
		rate.setPrice(BigDecimal.ONE);
		rate.setPriority(4);
		rate.setCurrency("EUR");

		assertEquals("1", rate.getBrandId());
		assertEquals("2", rate.getProductId());
		assertEquals("3", rate.getId());
		assertEquals(LocalDateTime.of(2020, 1, 1, 10, 0, 0), rate.getStartDate());
		assertEquals(LocalDateTime.of(2022, 2, 2, 22, 0, 0), rate.getEndDate());
		assertEquals(BigDecimal.ONE, rate.getPrice());
		assertEquals(4, rate.getPriority());
		assertEquals("EUR", rate.getCurrency());
	}

}