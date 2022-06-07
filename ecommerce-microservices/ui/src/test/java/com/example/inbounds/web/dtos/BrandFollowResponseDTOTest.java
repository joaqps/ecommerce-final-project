package com.example.inbounds.web.dtos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrandFollowResponseDTOTest {

	@Test
	void test_fields() {

		BrandFollowResponseDTO dto = new BrandFollowResponseDTO();
		dto.setMessage("msg");
		dto.setSuccessful(true);

		assertEquals("msg", dto.getMessage());
		assertTrue(dto.isSuccessful());
	}

	@Test
	void test_builder() {

		BrandFollowResponseDTO dto = BrandFollowResponseDTO.builder().message("msg").isSuccessful(true).build();

		assertEquals("msg", dto.getMessage());
		assertTrue(dto.isSuccessful());
	}

}