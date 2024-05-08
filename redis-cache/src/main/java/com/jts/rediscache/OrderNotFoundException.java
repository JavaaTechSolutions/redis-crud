package com.jts.rediscache;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrderNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 7428051251365675318L;

	public OrderNotFoundException(String message) {
		super(message);
	}
}