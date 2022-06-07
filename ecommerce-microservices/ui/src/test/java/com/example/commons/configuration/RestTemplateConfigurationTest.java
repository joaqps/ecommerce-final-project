package com.example.commons.configuration;

import io.jsonwebtoken.lang.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

class RestTemplateConfigurationTest {

	RestTemplateConfiguration configuration = new RestTemplateConfiguration();
	MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

	@Test
	void test_configuration() {
		Assert.notNull(configuration.getRestTemplate(converter));
	}
}