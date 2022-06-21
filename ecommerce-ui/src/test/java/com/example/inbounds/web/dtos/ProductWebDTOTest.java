package com.example.inbounds.web.dtos;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ProductWebDTOTest {

	@Test
	void test_fields() {

		ProductWebDTO dto = new ProductWebDTO();
		dto.setId("1");
		dto.setName("name");
		dto.setCategory("category");
		dto.setEndOfSaleDate(LocalDateTime.of(1, 1, 1, 1, 1));

		assertEquals("1", dto.getId());
		assertEquals("name", dto.getName());
		assertEquals("category", dto.getCategory());
		assertEquals(LocalDateTime.of(1, 1, 1, 1, 1), dto.getEndOfSaleDate());
	}

}