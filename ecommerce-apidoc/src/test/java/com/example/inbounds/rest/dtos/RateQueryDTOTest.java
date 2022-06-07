package com.example.inbounds.rest.dtos;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RateQueryDTOTest {

	@Test
	void test_fields() {

		RateQueryDTO dto = new RateQueryDTO();
		dto.setBrandId("1");
		dto.setProductId("2");
		dto.setDate(LocalDateTime.of(2022, 1, 1, 10, 0, 0));

		assertEquals("1", dto.getBrandId());
		assertEquals("2", dto.getProductId());
		assertEquals(LocalDateTime.of(2022, 1, 1, 10, 0, 0), dto.getDate());
		// RestDtoTester.test(dto, RateQueryDTO.JSON_TYPE_REF);
	}
}