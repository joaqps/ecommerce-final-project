package com.example.domain.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

	@Test
	void test_fields() {

		User user = new User();
		user.setUsername("John");
		user.setPassword("123456");

		assertEquals("John", user.getUsername());
		assertEquals("123456", user.getPassword());
	}

}