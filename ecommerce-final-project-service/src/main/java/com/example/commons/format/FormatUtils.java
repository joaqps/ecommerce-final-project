package com.example.commons.format;

import com.example.inbounds.rest.format.LocalDateTimeFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

public final class FormatUtils {

  private FormatUtils() {

  }

  public static ObjectMapper getMapper() {

    final var builder = Jackson2ObjectMapperBuilder.json();

    builder.failOnUnknownProperties(true);

    builder.serializers(new LocalDateTimeFormat.Serializer());
    builder.deserializers(new LocalDateTimeFormat.Deserializer());

    builder.modules(new JavaTimeModule());
    builder.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    builder.indentOutput(true);
    builder.propertyNamingStrategy(PropertyNamingStrategies.LOWER_CAMEL_CASE);

    return builder.build();
  }
}
