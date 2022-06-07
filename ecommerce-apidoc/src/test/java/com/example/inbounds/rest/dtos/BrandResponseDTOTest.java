package com.example.inbounds.rest.dtos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BrandResponseDTOTest {

	@Test
	void test_fields() {

		BrandResponseDTO dto = new BrandResponseDTO();
		dto.setName("Apple");

		assertEquals("Apple", dto.getName());
	}

	@Test
	void test_constructor() {

		BrandResponseDTO dto = new BrandResponseDTO("Apple");

		assertEquals("Apple", dto.getName());
	}
}