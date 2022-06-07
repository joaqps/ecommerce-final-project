package com.example.commons.configuration;

import io.jsonwebtoken.lang.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordEncoderConfigurationTest {

	PasswordEncoderConfiguration configuration = new PasswordEncoderConfiguration();

	@Test
	void test_configuration() {
		Assert.notNull(configuration.passwordEncoder());
	}
}