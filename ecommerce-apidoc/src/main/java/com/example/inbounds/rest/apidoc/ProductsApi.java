package com.example.inbounds.rest.apidoc;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

public interface ProductsApi {

	String MAIN_PATH = "/products";

//	static ApiInfo buildApiInfo() {
//
//		final var builder = new ApiInfoBuilder();
//		builder.title("Products API");
//		builder.description("REST API, offering management of products");
//		builder.version("0.0.1");
//		return builder.build();
//	}

	@Target({METHOD, TYPE, ANNOTATION_TYPE})
	@Retention(RetentionPolicy.RUNTIME)
	@Tag(name = "Products commands")
	@interface ProductCommand {
	}
}
