package com.example.inbounds.rest.dtos;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RateResponseDTOTest {

	@Test
	void test_fields() {

		RateResponseDTO dto = new RateResponseDTO();
		dto.setBrandId("1");
		dto.setProductId("2");
		dto.setStartDate(LocalDateTime.of(2020, 1, 1, 10, 0, 0));
		dto.setEndDate(LocalDateTime.of(2022, 2, 2, 22, 0, 0));
		dto.setPrice(BigDecimal.ONE);

		assertEquals("1", dto.getBrandId());
		assertEquals("2", dto.getProductId());
		assertEquals(LocalDateTime.of(2020, 1, 1, 10, 0, 0), dto.getStartDate());
		assertEquals(LocalDateTime.of(2022, 2, 2, 22, 0, 0), dto.getEndDate());
		assertEquals(BigDecimal.ONE, dto.getPrice());
		// RestDtoTester.test(dto, RateResponseDTO.JSON_TYPE_REF);
	}
}