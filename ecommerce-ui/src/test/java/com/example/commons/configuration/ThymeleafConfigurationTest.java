package com.example.commons.configuration;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ThymeleafConfigurationTest {

	ThymeleafConfiguration configuration = new ThymeleafConfiguration();

	@Test
	void test_bean() {
		assertNotNull(configuration.layoutDialect());
	}
}