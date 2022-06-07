package com.example.inbounds.rest.dtos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserResponseDTOTest {

	@Test
	void test_fields() {

		UserResponseDTO dto = new UserResponseDTO();
		dto.setUsername("John");
		dto.setPassword("123456");

		assertEquals("John", dto.getUsername());
		assertEquals("123456", dto.getPassword());
	}
}