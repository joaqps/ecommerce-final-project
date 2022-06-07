package com.example.inbounds.web.dtos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlertDTOTest {

	@Test
	void test_fields() {

		AlertDTO dto = new AlertDTO();
		dto.setMessage("msg");
		dto.setType("type");

		assertEquals("msg", dto.getMessage());
		assertEquals("type", dto.getType());
	}

}