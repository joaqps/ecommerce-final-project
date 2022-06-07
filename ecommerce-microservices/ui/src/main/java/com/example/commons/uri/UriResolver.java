package com.example.commons.uri;

import org.springframework.stereotype.Component;

@Component
public abstract class UriResolver {

	private static final String GATEWAY_BASE_PATH = "http://localhost:";
	private static final String GATEWAY_PORT = "8080";

	protected abstract String getEndPoint();

	public final String getRestUri() {
		return getBaseUri() + getEndPoint();
	}

	public String getFindOneUri(String param) {
		return getRestUri() + "/" + param;
	}

	private String getBaseUri() {
		return GATEWAY_BASE_PATH + GATEWAY_PORT;
	}
}
