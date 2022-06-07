package com.example.inbounds.rest.format;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class LocalDateTimeFormat {

	public static final String PATTERN = "yyyy-MM-dd HH:mm:ss";

	public static final String EXAMPLE = "2020-10-10 10:00:00";

	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(PATTERN);

	private LocalDateTimeFormat() {

	}

	public static final class Serializer extends StdSerializer<LocalDateTime> {

		@Override
		public Class<LocalDateTime> handledType() {
			return LocalDateTime.class;
		}

		public Serializer() {
			this(null);
		}

		public Serializer(final Class<LocalDateTime> t) {
			super(t);
		}

		@Override
		public void serialize(final LocalDateTime value, final JsonGenerator gen, final SerializerProvider provider)
				throws IOException {
			gen.writeString(DATE_FORMATTER.format(value));
		}

	}

	public static final class Deserializer extends StdDeserializer<LocalDateTime> {

		public Deserializer() {
			this(null);
		}

		public Deserializer(final Class<LocalDateTime> t) {
			super(t);
		}

		@Override
		public Class<LocalDateTime> handledType() {
			return LocalDateTime.class;
		}

		@Override
		public LocalDateTime deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {
			final String txt = p.getText();
			return LocalDateTime.parse(txt, DATE_FORMATTER);
		}

	}
}
