package com.example.commons.configuration;

import com.example.inbounds.rest.format.LocalDateTimeFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.formats.InstantDtoFormat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@Configuration
public class MapperConfiguration {

	@Primary
	@Bean
	public ObjectMapper getMapper() {
		return buildMapper();
	}

	public static ObjectMapper buildMapper() {

		final var builder = Jackson2ObjectMapperBuilder.json();

		builder.failOnUnknownProperties(true);

		builder.serializers(new LocalDateTimeFormat.Serializer());
		builder.deserializers(new LocalDateTimeFormat.Deserializer());

		builder.serializers(new InstantDtoFormat.Serializer());
		builder.deserializers(new InstantDtoFormat.Deserializer());

		builder.modules(new JavaTimeModule());
		builder.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

		builder.indentOutput(true);
		builder.propertyNamingStrategy(PropertyNamingStrategies.LOWER_CAMEL_CASE);

		return builder.build();
	}

	@Primary
	@Bean
	public MappingJackson2HttpMessageConverter getMessageConverter(ObjectMapper mapper) {
		return  new MappingJackson2HttpMessageConverter(mapper);
	}
}
