package io.pratik.Movie.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class GenreNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1740298621486163453L;

	public GenreNotFoundException(String message) {
		super(message);
	}

	public GenreNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}