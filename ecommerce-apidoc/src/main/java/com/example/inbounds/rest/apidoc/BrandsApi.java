package com.example.inbounds.rest.apidoc;

import io.swagger.v3.oas.annotations.tags.Tag;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;

public interface BrandsApi {

	String MAIN_PATH = "/brands";

	static ApiInfo buildApiInfo() {

		final var builder = new ApiInfoBuilder();
		builder.title("Brands API");
		builder.description("REST API, offering management of brands");
		builder.version("0.0.1");
		return builder.build();
	}

	@Target({METHOD, TYPE, ANNOTATION_TYPE})
	@Retention(RetentionPolicy.RUNTIME)
	@Tag(name = "Brands commands")
	@interface BrandCommand {
	}

	@Target({METHOD, TYPE, ANNOTATION_TYPE})
	@Retention(RetentionPolicy.RUNTIME)
	@Tag(name = "Brands queries")
	@interface BrandQuery {
	}
}
