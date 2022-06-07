package com.example.inbounds.rest.apidoc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RatesApiTest {

	@Test
	void test_api_info() {
		assertNotNull(RatesApi.buildApiInfo());
	}
}