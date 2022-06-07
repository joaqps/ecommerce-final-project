package com.example.commons.configuration;

import io.jsonwebtoken.lang.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThymeleafConfigurationTest {

	ThymeleafConfiguration configuration = new ThymeleafConfiguration();

	@Test
	void test_bean() {
		Assert.notNull(configuration.layoutDialect());
	}
}