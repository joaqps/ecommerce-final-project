package com.example.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

	@Test
	void test_fields() {

		User user = new User("1", "juan", "123456");

		assertEquals("1", user.getId());
		assertEquals("juan", user.getUsername());
		assertEquals("123456", user.getPassword());
	}

	@Test
	void test_builder() {

		User user = User.builder().id("1").username("juan").password("123456").build();

		assertEquals("1", user.getId());
		assertEquals("juan", user.getUsername());
		assertEquals("123456", user.getPassword());
	}
}