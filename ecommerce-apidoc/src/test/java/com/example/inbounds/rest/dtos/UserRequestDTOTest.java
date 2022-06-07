package com.example.inbounds.rest.dtos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserRequestDTOTest {

	@Test
	void test_fields() {

		UserRequestDTO dto = new UserRequestDTO();
		dto.setUsername("John");
		dto.setPassword("123456");

		assertEquals("John", dto.getUsername());
		assertEquals("123456", dto.getPassword());
	}
}