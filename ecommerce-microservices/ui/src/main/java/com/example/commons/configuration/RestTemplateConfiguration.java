package com.example.commons.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

	@Primary
	@Bean
	public RestTemplate getRestTemplate(MappingJackson2HttpMessageConverter converter) {

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, converter);

		return restTemplate;
	}
}
