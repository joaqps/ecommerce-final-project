package com.example.inbounds.rest.format;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.greyhawk.core.testutils.commons.JacksonMapperTester;
import org.junit.jupiter.api.Test;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.time.LocalDateTime;

class LocalDateTimeFormatTest {

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Dto {
		private LocalDateTime ldt;
	}

	@Test
	void test_serde() {
		final LocalDateTime ldt = LocalDateTime.now().withNano(0);
		new JacksonMapperTester(getMapper()).test(new Dto(ldt), new TypeReference<Dto>() {
		});
	}

	public ObjectMapper getMapper() {
		final var bldr = Jackson2ObjectMapperBuilder.json();

		bldr.serializers(new LocalDateTimeFormat.Serializer());
		bldr.deserializers(new LocalDateTimeFormat.Deserializer());

		bldr.modules(new JavaTimeModule());
		bldr.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

		return bldr.build();
	}

}