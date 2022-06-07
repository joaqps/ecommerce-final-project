package com.example.inbounds.web.dtos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginResponseDTOTest {

	@Test
	void test_fields() {

		LoginResponseDTO dto = new LoginResponseDTO();
		dto.setMessage("msg");
		dto.setSuccessful(true);

		assertEquals("msg", dto.getMessage());
		assertTrue(dto.isSuccessful());
	}

}