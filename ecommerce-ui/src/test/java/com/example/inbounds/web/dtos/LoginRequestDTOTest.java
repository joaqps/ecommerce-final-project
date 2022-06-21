package com.example.inbounds.web.dtos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginRequestDTOTest {

	@Test
	void test_fields() {

		LoginRequestDTO dto = new LoginRequestDTO();
		dto.setUsername("juan");
		dto.setPassword("123456");

		assertEquals("juan", dto.getUsername());
		assertEquals("123456", dto.getPassword());
	}

}