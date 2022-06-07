package com.example.domain.exceptions;

public class RateNotFoundException extends RuntimeException {

	public RateNotFoundException(String message) {
		super(message);
	}
}
