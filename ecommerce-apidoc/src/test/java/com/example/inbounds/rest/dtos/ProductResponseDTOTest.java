package com.example.inbounds.rest.dtos;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductResponseDTOTest {

	@Test
	void test_fields() {

		ProductResponseDTO dto = new ProductResponseDTO();
		dto.setId("1");
		dto.setName("Apple");
		dto.setCategory("Fruit");
		dto.setEndOfSaleDate(LocalDateTime.of(2022, 4, 27, 10, 30, 0));
		dto.setCreatedAt(LocalDateTime.of(2020, 1, 1, 10, 0, 0));
		dto.setUpdatedAt(LocalDateTime.of(2021, 2, 2, 11, 11, 11));

		assertEquals("1", dto.getId());
		assertEquals("Apple", dto.getName());
		assertEquals("Fruit", dto.getCategory());
		assertEquals(LocalDateTime.of(2022, 4, 27, 10, 30, 0), dto.getEndOfSaleDate());
		assertEquals(LocalDateTime.of(2020, 1, 1, 10, 0, 0), dto.getCreatedAt());
		assertEquals(LocalDateTime.of(2021, 2, 2, 11, 11, 11), dto.getUpdatedAt());
		// RestDtoTester.test(dto, ProductResponseDTO.JSON_TYPE_REF);
	}
}