package com.example.inbounds.web.dtos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrandWebDTOTest {

	@Test
	void test_fields() {

		BrandWebDTO dto = new BrandWebDTO();
		dto.setId("1");
		dto.setName("name");

		assertEquals("1", dto.getId());
		assertEquals("name", dto.getName());
	}

}