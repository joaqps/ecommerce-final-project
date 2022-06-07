package com.example.commons.configuration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MapperConfigurationTest {

	MapperConfiguration mapperConfiguration = new MapperConfiguration();

	@Test
	void test_beans() {
		Assertions.assertNotNull(mapperConfiguration.getMapper());
	}
}