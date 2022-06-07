package com.example.inbounds.rest.apidoc;

import io.swagger.v3.oas.annotations.tags.Tag;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

public interface UsersApi {

	String MAIN_PATH = "/users";

	static ApiInfo buildApiInfo() {

		final var builder = new ApiInfoBuilder();
		builder.title("Users API");
		builder.description("REST API, offering management of users");
		builder.version("0.0.1");
		return builder.build();
	}

	@Target({METHOD, TYPE, ANNOTATION_TYPE})
	@Retention(RetentionPolicy.RUNTIME)
	@Tag(name = "Users commands")
	@interface UserCommand {
	}
}
