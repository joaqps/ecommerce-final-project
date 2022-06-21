package com.example.inbounds.rest.apidoc;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

public interface RatesApi {

	String MAIN_PATH = "/rates";

//	static ApiInfo buildApiInfo() {
//
//		final var builder = new ApiInfoBuilder();
//		builder.title("Rates API");
//		builder.description("REST API, offering management of rates");
//		builder.version("0.0.1");
//		return builder.build();
//	}

	@Target({METHOD, TYPE, ANNOTATION_TYPE})
	@Retention(RetentionPolicy.RUNTIME)
	@Tag(name = "Rates commands")
	@interface RateCommand {
	}

	@Target({METHOD, TYPE, ANNOTATION_TYPE})
	@Retention(RetentionPolicy.RUNTIME)
	@Tag(name = "Rates queries")
	@interface RateQuery {
	}
}
