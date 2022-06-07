package com.example.inbounds.rest.apidoc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class UsersApiTest {

	@Test
	void test_api_info() {
		assertNotNull(UsersApi.buildApiInfo());
	}
}